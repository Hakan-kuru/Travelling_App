package com.example.Travelling_App.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Travelling_App.domain.models.User
import com.example.Travelling_App.domain.usecase.*
import com.example.Travelling_App.domain.usecase.userUsecase.DeleteUserUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.GetAllUsersUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.GetUserByIdUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.GetUserByUsernameUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.UpdateUserUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserByIdUsecase: GetUserByIdUsecase,
    private val updateUserUsecase: UpdateUserUsecase,
    private val deleteUserUsecase: DeleteUserUsecase,
    private val getUserByUsernameUsecase: GetUserByUsernameUsecase,
    private val getAllUsersUsecase: GetAllUsersUsecase
) : ViewModel() {

    fun getUserById(id: Int, onResult: (User?) -> Unit) {
        viewModelScope.launch {
            val user = getUserByIdUsecase(id)
            onResult(user)
        }
    }

    fun updateUser(user: User) {
        updateUserUsecase(user)
    }

    fun deleteUser(id: Int) {
        viewModelScope.launch {
            deleteUserUsecase(id)
        }
    }

    fun getUserByUsername(username: String, onResult: (User?) -> Unit) {
        viewModelScope.launch {
            val user = getUserByUsernameUsecase(username)
            onResult(user)
        }
    }

    fun getAllUsers(onResult: (List<User>) -> Unit) {
        viewModelScope.launch {
            val users = getAllUsersUsecase()
            onResult(users)
        }
    }
}
