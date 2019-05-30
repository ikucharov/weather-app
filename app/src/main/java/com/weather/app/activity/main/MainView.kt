package com.weather.app.activity.main

import com.weather.app.model.WeatherData
import com.weather.app.mvp.BaseView

interface MainView : BaseView {

    fun setData(data: List<WeatherData>)

    fun showLoading()

    fun hideLoading()

    fun showContent()

    fun hideContent()

    fun showApiError()

    fun showNetworkError()

    fun hideRefreshView()
}