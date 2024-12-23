package com.example.Travelling_App.domain.usecase

import com.example.Travelling_App.data.repositories.WeatherRepository
import com.example.Travelling_App.domain.models.Weather

class GetWeatherUsecase(private val weatherRepository: WeatherRepository) {

    suspend fun getWeatherByDestinationId(destinationId: Int): Weather? {
        return weatherRepository.getWeatherByDestinationId(destinationId)
    }

    suspend fun getAllWeather(): List<Weather> {
        return weatherRepository.getAllWeather()
    }

    suspend fun deleteWeatherById(weatherId: Int) {
        weatherRepository.deleteWeatherById(weatherId)
    }

    suspend fun deleteAllWeather() {
        weatherRepository.deleteAllWeather()
    }

    suspend fun insertWeather(weather: Weather) {
        weatherRepository.insertWeather(weather)
    }
}