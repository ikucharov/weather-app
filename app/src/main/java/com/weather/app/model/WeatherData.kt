package com.weather.app.model

data class WeatherData(
    val id: Long,
    val name: String,
    val coord: Coord,
    val main: Main,
    val dt: String,
    val wind: Wind,
    val clouds: Clouds,
    val weather: List<Weather>
)