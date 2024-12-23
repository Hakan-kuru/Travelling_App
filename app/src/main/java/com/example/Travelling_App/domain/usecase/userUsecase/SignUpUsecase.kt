package com.example.Travelling_App.domain.usecase.userUsecase

import com.example.Travelling_App.domain.models.User
import com.example.Travelling_App.data.repositories.UserRepository

class SignUpUsecase(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User): Boolean {
        return try {
            userRepository.addUser(user)
            true
        } catch (e: Exception) {
            false
        }
    }
}
