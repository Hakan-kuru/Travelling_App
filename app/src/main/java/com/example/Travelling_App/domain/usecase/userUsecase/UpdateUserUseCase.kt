package com.example.Travelling_App.domain.usecase.userUsecase

import com.example.Travelling_App.data.database.repositories.UserRepository
import com.example.Travelling_App.domain.models.User
import javax.inject.Inject

class UpdateUserUsecase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(user: User) {
        userRepository.updateUser(user)
    }
}
