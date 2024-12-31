package com.example.Travelling_App.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Travelling_App.domain.models.Weather
import com.example.Travelling_App.domain.usecase.GetWeatherUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeatherUsecase: GetWeatherUsecase) : ViewModel(){

    fun deleteWeatherById(weatherId: Int, onComplete: () -> Unit) {
        viewModelScope.launch {
            getWeatherUsecase.deleteWeatherById(weatherId)
            onComplete()
        }
    }

    fun deleteAllWeather(onComplete: () -> Unit) {
        viewModelScope.launch {
            getWeatherUsecase.deleteAllWeather()
            onComplete()
        }
    }

    fun getWeatherByDestinationId(destinationId: Int, onResult: (Weather?) -> Unit) {
        viewModelScope.launch {
            val weather = getWeatherUsecase.getWeatherByDestinationId(destinationId)
            onResult(weather)
        }
    }


    fun getAllWeather(onResult: (List<Weather>) -> Unit) {
        viewModelScope.launch {
            val weather = getWeatherUsecase.getAllWeather()
            onResult(weather)
        }
    }

    fun insertWeather(weather: Weather, onComplete: () -> Unit) {
        viewModelScope.launch {
            getWeatherUsecase.insertWeather(weather)
            onComplete()
        }
    }

    fun updateWeather(weather: Weather, onComplete: () -> Unit) {
        viewModelScope.launch {
            getWeatherUsecase.insertWeather(weather)
            onComplete()
        }
    }
}