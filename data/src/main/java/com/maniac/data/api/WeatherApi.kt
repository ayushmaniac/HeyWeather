package com.maniac.data.api

import com.maniac.domain.model.WeatherDataTransferObject
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(Endpoint.WEATHER_ENDPOINT)
    suspend fun getWeatherData(
        @Query("latitude") lat : Double,
        @Query("longitude") long : Double
    ) : WeatherDataTransferObject
}