package com.example.projectweather.data.remote.model

data class WeatherApiModel (
    val temperature: String,
    val wind: String,
    val description: String,
    val forecast: List<WeatherForecastApiModel>
)

