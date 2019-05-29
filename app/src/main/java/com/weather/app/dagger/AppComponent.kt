package com.weather.app.dagger

import com.weather.app.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    fun plus(presenterModule: PresenterModule): PresenterComponent

    fun inject(app: App)
}
