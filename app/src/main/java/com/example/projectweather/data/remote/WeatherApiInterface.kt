package com.example.projectweather.data.remote

import com.example.projectweather.data.remote.model.WeatherApiModel
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApiInterface {

    @GET("Kremenchug")
    suspend fun getWeather(): Response<WeatherApiModel>
}