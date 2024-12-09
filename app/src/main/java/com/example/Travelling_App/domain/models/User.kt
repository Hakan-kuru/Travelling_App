package com.example.Travelling_App.domain.models

class User(
    val userId: Int,
    val username: String,
    val email: String,
    val budget: Double?,
    val preferences: String?,
    val password: String
)