package com.maniac.domain.usecases

import com.maniac.domain.common.Resource
import com.maniac.domain.model.WeatherDataTransferObject
import com.maniac.domain.repo.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(
        private val weatherRepository: WeatherRepository
) {
    operator fun invoke(params : Pair<Double, Double>) : Flow<Resource<WeatherDataTransferObject>> = flow {
        try {
            emit(Resource.Loading())
            val weatherData = weatherRepository.getWeatherData(params.first, params.second)
            emit(Resource.Success(weatherData))
        }
        catch (e : Exception){
            emit(Resource.Error("Something went wrong!"))
        }
    }
}