package com.weather.app.dagger

import com.weather.app.activity.main.MainPresenter
import com.weather.app.api.Api
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesMainPresenter(api: Api): MainPresenter = MainPresenter(api)
}