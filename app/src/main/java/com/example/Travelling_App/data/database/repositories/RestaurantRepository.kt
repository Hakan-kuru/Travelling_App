package com.example.Travelling_App.data.database.repositories

import com.example.Travelling_App.data.database.local.daos.RestaurantDao
import com.example.Travelling_App.data.database.local.entity.RestaurantEntity
import com.example.Travelling_App.domain.models.Restaurant

class RestaurantRepository(private val restaurantDao: RestaurantDao) {

    suspend fun getRestaurantById(id: Int): Restaurant? {
        return restaurantDao.getRestaurantById(id)?.toDomainModel()
    }

    suspend fun getRestaurantByDestinationId(destinationId: Int): Restaurant? {
        return restaurantDao.getRestaurantByDestinationId(destinationId)?.toDomainModel()
    }

    suspend fun getRestaurantByName(name: String): Restaurant? {
        return restaurantDao.getRestaurantByName(name)?.toDomainModel()
    }

    suspend fun deleteRestaurantById(id: Int) {
        restaurantDao.deleteRestaurantById(id)
    }

    suspend fun getAllRestaurants(): List<Restaurant> {
        return restaurantDao.getAllRestaurants().map { it.toDomainModel() }
    }

    suspend fun insertRestaurant(restaurant: Restaurant) {
        return restaurantDao.insertRestaurant(restaurant.toEntity())
    }

    suspend fun updateRestaurant(restaurant: Restaurant) {
        return restaurantDao.insertRestaurant(restaurant.toEntity())
    }

    suspend fun deleteAllRestaurants() {
        restaurantDao.deleteAllRestaurants()
    }
    // diğerlerini sonra yazarız
}

// Dönüşüm fonksiyonları
fun RestaurantEntity.toDomainModel() = Restaurant( restaurantId, destinarionId, restaurantName, description, cuisineType, rating, priceRange, number)
fun Restaurant.toEntity() = RestaurantEntity( restaurantId, destinarionId, restaurantName, description, cuisineType, rating, priceRange, number)
