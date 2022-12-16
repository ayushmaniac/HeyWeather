package com.maniac.heyweather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maniac.data.repo.WeatherRepositoryImpl
import com.maniac.domain.common.Resource
import com.maniac.domain.model.WeatherDataTransferObject
import com.maniac.domain.usecases.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
) : ViewModel() {

    private val _weatherData : MutableLiveData<Resource<WeatherDataTransferObject>> = MutableLiveData<Resource<WeatherDataTransferObject>>()

    fun getWeatherData(lat: Double, long: Double) {
        viewModelScope.launch {
            getWeatherDataUseCase.invoke(Pair(lat, long)).collect()
        }
    }

}