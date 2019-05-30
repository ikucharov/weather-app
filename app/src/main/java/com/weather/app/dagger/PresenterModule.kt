package com.weather.app.dagger

import com.google.gson.Gson
import com.weather.app.activity.details.WeatherDetailsPresenter
import com.weather.app.activity.main.MainPresenter
import com.weather.app.api.Api
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesMainPresenter(api: Api): MainPresenter = MainPresenter(api)

    @Provides
    fun providesDetailsPresenter(gson: Gson): WeatherDetailsPresenter = WeatherDetailsPresenter(gson)
}