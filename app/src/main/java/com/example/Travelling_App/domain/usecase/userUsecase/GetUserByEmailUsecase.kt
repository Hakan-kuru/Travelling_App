package com.example.Travelling_App.domain.usecase.userUsecase

import com.example.Travelling_App.data.repositories.UserRepository
import com.example.Travelling_App.domain.models.User
import javax.inject.Inject

class GetUserByEmailUsecase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(email: String): User? {
        return userRepository.getUserByEmail(email)
    }
}
