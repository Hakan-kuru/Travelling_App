package com.example.Travelling_App.data.repositories

import com.example.Travelling_App.data.database.local.daos.UserDao
import com.example.Travelling_App.data.database.local.entity.UserEntity
import com.example.Travelling_App.data.database.remote.api.UserApiService
import com.example.Travelling_App.domain.models.User
import kotlinx.coroutines.runBlocking

class UserRepository(private val userDao: UserDao, private val userApiService: UserApiService) {

    suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)?.toDomainModel()
    }

    suspend fun getUser(id: Int): User? {
        return userDao.getUserById(id)?.toDomainModel()
    }



    suspend fun deleteUser(id: Int) {
        userDao.deleteUserById(id)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers().map { it.toDomainModel() }
    }

    fun updateUser(user: User) {
        runBlocking {
            userDao.insertUser(user.toEntity())
        }
    }

    suspend fun addUser(user: User) {
        userDao.insertUser(user.toEntity())
    }

    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)?.toDomainModel()
    }

    // diğerlerini sonra yazarız
}

// Dönüşüm fonksiyonları
fun UserEntity.toDomainModel() = User(userId, username, email, budget, preferences, password)
fun User.toEntity() = UserEntity(userId, username, email, budget, preferences, password)

/*

// Kullanıcıyı username ile arar
suspend fun getUserByUsername(username: String): User? {
 return userApiService.getUserByUsername(username)?.toDomainModel()
}

// Kullanıcıyı email ile arar
suspend fun getUserByEmail(email: String): User? {
 return userApiService.getUserByEmail(email)?.toDomainModel()
}

// Kullanıcıyı ID ile arar
suspend fun getUserById(id: Int): User? {
 return userApiService.getUserById(id)?.toDomainModel()
}

// Tüm kullanıcıları getirir
suspend fun getAllUsers(): List<User> {
 return userApiService.getAllUsers().map { it.toDomainModel() }
}

// Kullanıcı ekler
suspend fun addUser(user: User) {
 userApiService.addUser(user.toDto())
}

// Kullanıcıyı günceller
suspend fun updateUser(user: User) {
 userApiService.updateUser(user.toDto())
}

// Kullanıcıyı siler
suspend fun deleteUser(id: Int) {
 userApiService.deleteUser(id)
}


}
*/
