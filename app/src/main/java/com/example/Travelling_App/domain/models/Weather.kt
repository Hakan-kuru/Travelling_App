package com.example.Travelling_App.domain.models

class Weather (
    val weatherId: Int = 0,
    val destinationId: Int,
    val humidity: Double,//nem gerekli mi ki?
    val windSpeed: Double,
    val season: String,
    val averageTemp: Double
)