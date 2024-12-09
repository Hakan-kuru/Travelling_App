package com.example.Travelling_App.domain.usecase

import com.example.Travelling_App.data.database.repositories.UserRepository
import com.example.Travelling_App.domain.models.User

// execute neden kullanılmıyor ona bak
class GetUserUsecase( private val userRepository: UserRepository) {

    suspend fun getUser(id: Int): User? {
        return userRepository.getUser(id)
    }

    fun updateUser(user: User) {
        userRepository.updateUser(user)
    }

    suspend fun deleteUser(id: Int) {
        userRepository.deleteUser(id)
    }

    suspend fun getUserByUsername(username: String): User? {
        return userRepository.getUserByUsername(username)
    }

    suspend fun getAllUsers(): List<User> {
        return userRepository.getAllUsers()
    }
}
