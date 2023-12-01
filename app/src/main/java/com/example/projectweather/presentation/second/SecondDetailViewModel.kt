package com.example.projectweather.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectweather.data.remote.model.WeatherForecastApiModel
import com.example.projectweather.domain.WeatherUsecase
import kotlinx.coroutines.launch

class SecondDetailViewModel : ViewModel() {
    private val weatherUsecase = WeatherUsecase

    val nextThreeDaysWeather = MutableLiveData<List<WeatherForecastApiModel>?>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getNextThreeDaysData()
    }

    fun getNextThreeDaysData() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val data = weatherUsecase.getWeather()?.forecast?.take(3)
            nextThreeDaysWeather.postValue(data)

            isLoading.postValue(false)
        }
    }
}