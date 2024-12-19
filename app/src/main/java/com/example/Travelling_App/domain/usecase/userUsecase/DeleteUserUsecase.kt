package com.example.Travelling_App.domain.usecase.userUsecase

import com.example.Travelling_App.data.database.repositories.UserRepository
import javax.inject.Inject

class DeleteUserUsecase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int) {
        userRepository.deleteUser(id)
    }
}
