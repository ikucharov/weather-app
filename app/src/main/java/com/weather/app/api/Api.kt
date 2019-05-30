package com.weather.app.api

import com.weather.app.model.Data
import com.weather.app.model.WeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("data/2.5/box/city")
    fun getWeatherData(
        @Query("appid") appid: String,
        @Query("bbox") bbox: Array<Int>
    ): Observable<Data>
}
