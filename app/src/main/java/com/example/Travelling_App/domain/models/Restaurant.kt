package com.example.Travelling_App.domain.models

import androidx.room.PrimaryKey

class Restaurant (
    @PrimaryKey val restaurantId: Int,
    val destinarionId: Int,
    val restaurantName: String,
    val description: String,
    val cuisineType: String,
    val rating: Double,
    val priceRange: String,
    val number: Int
)