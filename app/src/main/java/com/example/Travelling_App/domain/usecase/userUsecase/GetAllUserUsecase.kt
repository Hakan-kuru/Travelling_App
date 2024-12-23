package com.example.Travelling_App.domain.usecase.userUsecase

import com.example.Travelling_App.data.repositories.UserRepository
import com.example.Travelling_App.domain.models.User
import javax.inject.Inject

class GetAllUsersUsecase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): List<User> {
        return userRepository.getAllUsers()
    }
}
