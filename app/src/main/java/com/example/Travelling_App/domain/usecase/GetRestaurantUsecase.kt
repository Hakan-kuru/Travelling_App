package com.example.Travelling_App.domain.usecase

import com.example.Travelling_App.data.database.repositories.RestaurantRepository
import com.example.Travelling_App.domain.models.Restaurant

class GetRestaurantUsecase (private val restaurantRepository: RestaurantRepository){
    suspend fun deleteRestaurantById(restaurantId: Int) {
        restaurantRepository.deleteRestaurantById(restaurantId)
    }

    suspend fun insertRestaurant(restaurant: Restaurant) {
        restaurantRepository.insertRestaurant(restaurant)
    }

    suspend fun deleteAllRestaurants() {
        restaurantRepository.deleteAllRestaurants()
    }

    suspend fun getRestaurantById(restaurantId: Int): Restaurant? {
        return restaurantRepository.getRestaurantById(restaurantId)
    }

    suspend fun getRestaurantByName(name: String): Restaurant? {
        return restaurantRepository.getRestaurantByName(name)
    }

    suspend fun getRestaurantByDestinationId(destinationId: Int): Restaurant? {
        return restaurantRepository.getRestaurantByDestinationId(destinationId)
    }

    suspend fun getAllRestaurants(): List<Restaurant> {
        return restaurantRepository.getAllRestaurants()
    }
    suspend fun updateRestaurant(restaurant: Restaurant) {
        return restaurantRepository.updateRestaurant(restaurant)
    }
}