package com.maniac.data.repo

import com.maniac.data.api.WeatherApi
import com.maniac.domain.model.WeatherDataTransferObject
import com.maniac.domain.repo.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi : WeatherApi
) : WeatherRepository{

    override suspend fun getWeatherData(
        lat: Double,
        long: Double
    ): WeatherDataTransferObject = weatherApi.getWeatherData(lat,long)

}