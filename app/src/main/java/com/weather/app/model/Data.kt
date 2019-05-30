package com.weather.app.model

data class Data(
    val cod: String,
    val calctime: Float,
    val cnt: Int,
    val list: List<WeatherData>
)