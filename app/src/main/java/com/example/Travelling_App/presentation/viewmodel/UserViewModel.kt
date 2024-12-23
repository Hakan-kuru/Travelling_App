package com.example.Travelling_App.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Travelling_App.domain.models.User
import com.example.Travelling_App.domain.usecase.userUsecase.DeleteUserUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.GetAllUsersUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.GetUserByEmailUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.GetUserByIdUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.GetUserByUsernameUsecase
import com.example.Travelling_App.domain.usecase.userUsecase.SignUpUsecase
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
    private val getAllUsersUsecase: GetAllUsersUsecase,
    private val signUpUseCase: SignUpUsecase,
    private val getUserByEmailUsecase: GetUserByEmailUsecase
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
    fun signUp(
        username: String,
        email: String,
        password: String,
        budget: Double?,
        preferences: String?,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val user = User(
                userId = 0, // Otomatik atanacağını varsayıyoruz.
                username = username,
                email = email,
                password = password,
                budget = budget,
                preferences = preferences
            )
            val result = signUpUseCase(user)
            onResult(result)
        }
    }
    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = getUserByEmailUsecase(email)
            if (user != null && user.password == password) {
                onResult(true)
            } else {
                onResult(false)
            }
        }
    }


}
