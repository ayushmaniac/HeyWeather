package com.maniac.domain.repo

import com.maniac.domain.model.WeatherDataTransferObject

interface WeatherRepository {
    suspend fun getWeatherData(lat : Double, long: Double) : WeatherDataTransferObject
}