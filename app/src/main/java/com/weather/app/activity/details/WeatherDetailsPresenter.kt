package com.weather.app.activity.details

import android.annotation.SuppressLint
import com.google.gson.Gson
import com.weather.app.model.WeatherData
import com.weather.app.mvp.Presenter

class WeatherDetailsPresenter(private val gson: Gson) : Presenter<WeatherDetailsView>() {

    @SuppressLint("CheckResult")
    fun initData(data: String) {
        getView()?.setData(gson.fromJson(data, WeatherData::class.java))
    }
}