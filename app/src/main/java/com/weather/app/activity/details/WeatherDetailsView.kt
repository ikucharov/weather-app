package com.weather.app.activity.details

import com.weather.app.model.WeatherData
import com.weather.app.mvp.BaseView

interface WeatherDetailsView : BaseView {

    fun setData(data: WeatherData)
}