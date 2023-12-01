package com.example.projectweather.domain

import com.example.projectweather.data.WeatherRepository
import com.example.projectweather.data.remote.model.WeatherApiModel

object WeatherUsecase {

    private val repo = WeatherRepository

    suspend fun getWeather(): WeatherApiModel? {
        val data = repo.getWeather()
        return data
    }

}