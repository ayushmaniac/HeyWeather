package com.maniac.heyweather

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HeyWeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("HeyWeatherApplication", "Application Started")
    }
}