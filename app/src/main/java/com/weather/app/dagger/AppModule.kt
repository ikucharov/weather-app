package com.weather.app.dagger

import android.app.Application
import android.content.Context
import com.weather.app.utils.PreferencesUtil
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private var application: Application) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun providesPreferences(context: Context): PreferencesUtil {
        val sharedPreferences = context.getSharedPreferences("OauthPrefs", Context.MODE_PRIVATE)
        return PreferencesUtil(context, sharedPreferences)
    }
}
