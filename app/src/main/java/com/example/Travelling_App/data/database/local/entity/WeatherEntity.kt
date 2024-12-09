package com.example.Travelling_App.data.database.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val weatherId: Int = 0,
    val destinationId: Int,
    val humidity: Double,//nem gerekli mi ki?
    val windSpeed: Double,
    val season: String,
    val averageTemp: Double
)