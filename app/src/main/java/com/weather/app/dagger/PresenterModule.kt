package com.weather.app.dagger

import com.weather.app.activity.main.MainPresenter
import com.weather.app.utils.PreferencesUtil
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesMainPresenter(): MainPresenter = MainPresenter()
}