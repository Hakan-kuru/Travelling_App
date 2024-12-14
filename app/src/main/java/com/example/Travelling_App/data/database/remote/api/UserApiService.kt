package com.example.Travelling_App.data.database.remote.api

import com.example.Travelling_App.data.database.remote.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApiService {

    @GET("users/username/{username}")
    suspend fun getUserByUsername(
        @Path("username") username: String
    ): UserDto?

    @GET("users/email/{email}")
    suspend fun getUserByEmail(
        @Path("email") email: String
    ): UserDto?

    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") id: Int
    ): UserDto?

    @GET("users")
    suspend fun getAllUsers(): List<UserDto>

    @POST("users")
    suspend fun addUser(
        @Body user: UserDto
    )

    @PUT("users")
    suspend fun updateUser(
        @Body user: UserDto
    )

    @DELETE("users/{id}")
    suspend fun deleteUser(
        @Path("id") id: Int
    )
}
