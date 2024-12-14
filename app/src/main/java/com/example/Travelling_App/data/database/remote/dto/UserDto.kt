package com.example.Travelling_App.data.database.remote.dto

import com.example.Travelling_App.domain.models.User

data class UserDto(
    val userId: Int,
    val username: String,
    val email: String,
    val budget: Double?,
    val preferences: String?,
    val password: String
)
fun UserDto.toDomainModel(): User {
    return User(
        userId = this.userId,
        username = this.username,
        email = this.email,
        budget = this.budget,
        preferences = this.preferences,
        password = this.password
    )
}
fun User.toDto(): UserDto {
    return UserDto(
        userId = this.userId,
        username = this.username,
        email = this.email,
        budget = this.budget,
        preferences = this.preferences,
        password = this.password
    )
}
