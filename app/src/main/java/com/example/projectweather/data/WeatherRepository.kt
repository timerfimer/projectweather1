package com.example.projectweather.data

import com.example.projectweather.data.remote.ApiFactory
import com.example.projectweather.data.remote.model.WeatherApiModel

object WeatherRepository {
    private val api = ApiFactory.weatherApi

    suspend fun getWeather() : WeatherApiModel? {

        val dataFromInternet = api.getWeather()

        if (dataFromInternet.isSuccessful && dataFromInternet.body()!=null) {
            return dataFromInternet.body()
        } else return null
    }
}