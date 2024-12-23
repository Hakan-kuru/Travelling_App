package com.example.Travelling_App.data.repositories

import com.example.Travelling_App.data.database.local.daos.WeatherDao
import com.example.Travelling_App.data.database.local.entity.WeatherEntity
import com.example.Travelling_App.domain.models.Weather

class WeatherRepository(private val weatherDao: WeatherDao)  {
    suspend fun getWeatherByDestinationId(destinationId: Int): Weather? {
        return weatherDao.getWeatherByDestinationId(destinationId)?.toDomainModel()
    }
    suspend fun getAllWeather(): List<Weather> {
        return weatherDao.getAllWeather().map { it.toDomainModel() }
    }

    suspend fun deleteWeatherById(weatherId: Int) {
        weatherDao.deleteWeatherById(weatherId)
    }
    suspend fun deleteAllWeather() {
        weatherDao.deleteAllWeather()
    }
    suspend fun insertWeather(weather: Weather) {
        weatherDao.insertWeather(weather.toEntity())
    }
}
// Dönüşüm fonksiyonları
fun WeatherEntity.toDomainModel() = Weather(weatherId, destinationId, humidity, windSpeed, season, averageTemp)
fun Weather.toEntity() = WeatherEntity(weatherId, destinationId, humidity, windSpeed, season, averageTemp)
