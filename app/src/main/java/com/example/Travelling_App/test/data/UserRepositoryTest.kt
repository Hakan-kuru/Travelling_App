package com.example.Travelling_App.test.data

import com.example.Travelling_App.data.database.local.entity.UserEntity
import com.example.Travelling_App.data.repositories.toDomainModel
import com.example.Travelling_App.data.repositories.toEntity
import com.example.Travelling_App.domain.models.User
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class UserRepositoryTest {

    private lateinit var testUser: User
    private lateinit var testUserEntity: UserEntity

    @Before
    fun setUp() {
        // Test için kullanılacak User ve UserEntity nesneleri
        testUser = User(
            userId = 1,
            username = "testUser",
            email = "test@example.com",
            budget = 1000.0,
            preferences = "Travel, Adventure",
            password = "securePassword"
        )

        testUserEntity = UserEntity(
            userId = 1,
            username = "testUser",
            email = "test@example.com",
            budget = 1000.0,
            preferences = "Travel, Adventure",
            password = "securePassword"
        )
    }

    @Test
    fun toEntity_converts_User_to_UserEntity_correctly()  {
        // User nesnesini UserEntity'ye dönüştür
        val result = testUser.toEntity()

        // Beklenen değerlerle karşılaştır
        assertEquals(testUser.userId, result.userId)
        assertEquals(testUser.username, result.username)
        assertEquals(testUser.email, result.email)
        testUser.budget?.let { result.budget?.let { it1 -> assertEquals(it, it1, 0.01) } }
        assertEquals(testUser.preferences, result.preferences)
        assertEquals(testUser.password, result.password)
    }

    @Test
    fun toDomainModel_converts_UserEntity_to_User_correctly() {
        // UserEntity nesnesini User'a dönüştür
        val result = testUserEntity.toDomainModel()

        // Beklenen değerlerle karşılaştır
        assertEquals(testUserEntity.userId, result.userId)
        assertEquals(testUserEntity.username, result.username)
        assertEquals(testUserEntity.email, result.email)
        testUserEntity.budget?.let { result.budget?.let { it1 -> assertEquals(it, it1, 0.01) } }
        assertEquals(testUserEntity.preferences, result.preferences)
        assertEquals(testUserEntity.password, result.password)
    }
}
