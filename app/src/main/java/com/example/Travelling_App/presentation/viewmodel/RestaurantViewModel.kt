package com.example.Travelling_App.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.Travelling_App.domain.models.Restaurant
import com.example.Travelling_App.domain.usecase.GetRestaurantUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val getRestaurantUsecase: GetRestaurantUsecase
) : ViewModel() {
    fun deleteRestaurantById(restaurantId: Int, onComplete: () -> Unit) {
        viewModelScope.launch {
            getRestaurantUsecase.deleteRestaurantById(restaurantId)
            onComplete()
        }
    }
    fun deleteAllRestaurants(onComplete: () -> Unit) {
        viewModelScope.launch {
            getRestaurantUsecase.deleteAllRestaurants()
            onComplete()
        }
    }
    fun getRestaurantByDestinationId(destinationId: Int, onResult: (Restaurant?) -> Unit) {
        viewModelScope.launch {
            val restaurant = getRestaurantUsecase.getRestaurantByDestinationId(destinationId)
            onResult(restaurant)
        }
    }
    fun getAllRestaurants(onResult: (List<Restaurant>) -> Unit) {
        viewModelScope.launch {
            val restaurants = getRestaurantUsecase.getAllRestaurants()
            onResult(restaurants)
        }
    }
    fun insertRestaurant(restaurant: Restaurant, onComplete: () -> Unit) {
        viewModelScope.launch {
            getRestaurantUsecase.insertRestaurant(restaurant)
            onComplete()
        }
    }
    fun updateRestaurant(restaurant: Restaurant, onComplete: () -> Unit) {
        viewModelScope.launch {
            getRestaurantUsecase.updateRestaurant(restaurant)
            onComplete()
        }
    }
    fun getRestaurantByName(name: String, onResult: (Restaurant?) -> Unit) {
        viewModelScope.launch {
            val restaurant = getRestaurantUsecase.getRestaurantByName(name)
            onResult(restaurant)
        }
    }
    fun getRestaurantById(restaurantId: Int, onResult: (Restaurant?) -> Unit) {
        viewModelScope.launch {
            val restaurant = getRestaurantUsecase.getRestaurantById(restaurantId)
            onResult(restaurant)
        }
    }

}