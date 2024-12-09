package com.example.Travelling_App.data.database.local.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.Travelling_App.data.database.local.entity.RestaurantEntity

interface RestaurantDao {
    @Query("SELECT * FROM restaurant_table WHERE restaurantName = :restaurantName")
    suspend fun getRestaurantByName(restaurantName: String): RestaurantEntity?

    @Query("SELECT * FROM restaurant_table WHERE restaurantId = :restaurantId")
    suspend fun getRestaurantById(restaurantId: Int): RestaurantEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: RestaurantEntity)

    @Query("SELECT * FROM restaurant_table WHERE number= :number")
    suspend fun getRestaurantByNumber(number: Int): RestaurantEntity?

    @Query("DELETE FROM restaurant_table WHERE restaurantId = :restaurantId")
    suspend fun deleteRestaurantById(restaurantId: Int)

    @Query("SELECT* FROM restaurant_table ")
    suspend fun getAllRestaurants(): List<RestaurantEntity>

    @Query("DELETE FROM restaurant_table WHERE destinarionId = :destinationId")
    suspend fun getRestaurantByDestinationId(destinationId: Int): RestaurantEntity?

    @Query("DELETE FROM restaurant_table")
    suspend fun deleteAllRestaurants()
}