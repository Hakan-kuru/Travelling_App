package com.example.Travelling_App.data.database.local.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.Travelling_App.data.database.local.entity.WeatherEntity
import androidx.room.Query

interface WeatherDao {
    @Query("SELECT * FROM weather_table WHERE destinationId = :destinationId")
    suspend fun getWeatherByDestinationId(destinationId: Int): WeatherEntity?

    @Query("SELECT * FROM weather_table")
    suspend fun getAllWeather(): List<WeatherEntity>

    @Query("DELETE FROM weather_table WHERE weatherId = :weatherId")
    suspend fun deleteWeatherById(weatherId: Int)

    @Query("DELETE FROM weather_table")
    suspend fun deleteAllWeather()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)
}