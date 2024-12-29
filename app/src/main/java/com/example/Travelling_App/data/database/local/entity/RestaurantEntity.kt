package com.example.Travelling_App.data.database.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class RestaurantEntity(
    @PrimaryKey val restaurantId: Int,
    val destinarionId: Int,
    val restaurantName: String,
    val description: String,
    val cuisineType: String,
    val rating: Double,
    val priceRange: String,
    val number: Int,
    val image: String
)