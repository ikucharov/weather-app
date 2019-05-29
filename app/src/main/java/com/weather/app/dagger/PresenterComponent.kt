package com.weather.app.dagger

import com.weather.app.activity.main.MainActivity
import com.weather.app.dagger.PresenterModule
import com.weather.app.dagger.PresenterScope
import dagger.Subcomponent

@PresenterScope
@Subcomponent(
    modules = [
        PresenterModule::class
    ]
)
interface PresenterComponent {

    fun inject(mainActivity: MainActivity)
}
