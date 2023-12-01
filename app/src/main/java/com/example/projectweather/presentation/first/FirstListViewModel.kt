package com.example.projectweather.presentation.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectweather.data.remote.model.WeatherApiModel
import com.example.projectweather.domain.WeatherUsecase
import kotlinx.coroutines.launch

class FirstListViewModel : ViewModel() {

    private val weatherUsecase = WeatherUsecase

    val weatherLd = MutableLiveData<WeatherApiModel?>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getAllData()
    }

    fun getAllData() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val data = weatherUsecase.getWeather()
            weatherLd.postValue(data)

            isLoading.postValue(false)
        }
    }

}
