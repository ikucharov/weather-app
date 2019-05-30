package com.weather.app.activity.details

import android.os.Bundle
import com.weather.app.App
import com.weather.app.R
import com.weather.app.activity.BaseMvpActivity
import com.weather.app.model.WeatherData
import com.weather.app.utils.Constants
import com.weather.app.utils.GlideApp
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_weather_details.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class WeatherDetailsActivity : BaseMvpActivity<WeatherDetailsView, WeatherDetailsPresenter>(),
    WeatherDetailsView {

    @Inject
    lateinit var presenterProvider: Lazy<WeatherDetailsPresenter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)
        setSupportActionBar(toolbar)
        setHomeAsUp()
        title = intent.getStringExtra(Constants.EXTRA_TITLE)

        presenter.initData(intent.getStringExtra(Constants.EXTRA_DATA))
    }

    override fun setData(data: WeatherData) {
        val weather = data.weather[0]

        temp.text = data.main.temp.toString() + " C"
        tempMin.text = "Temp min: " + data.main.temp_min.toString() + " C"
        tempMax.text = "Temp max: " + data.main.temp_max.toString() + " C"

        seaLevel.text = "Sea level: " + data.main.sea_level.toString() + " m"
        grnLevel.text = "Ground level: " + data.main.grnd_level.toString() + " m"

        description.text = weather.main + ": " + weather.description
        speed.text = "Speed " + data.wind.speed.toString() + " m/s"
        cloud.text = "Cloud " + data.clouds.all.toString() + " %"

        let {
            GlideApp.with(it).load(Constants.BASE_PHOTO_URL + weather.icon + ".png").centerCrop()
                .into(thumbnail)
        }
    }

    override fun dependencyInject() {
        App.getPresenterComponent().inject(this)
    }

    override fun createPresenter(): WeatherDetailsPresenter = presenterProvider.get()

    override fun getMvpView(): WeatherDetailsView = this
}
