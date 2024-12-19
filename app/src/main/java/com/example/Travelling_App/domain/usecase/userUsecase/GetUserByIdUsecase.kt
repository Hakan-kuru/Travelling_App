package com.example.Travelling_App.domain.usecase.userUsecase

import com.example.Travelling_App.data.database.repositories.UserRepository
import com.example.Travelling_App.domain.models.User
import javax.inject.Inject

class GetUserByIdUsecase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int): User? {
        return userRepository.getUser(id)
    }
}
