package com.weather.app.activity.main

import android.annotation.SuppressLint
import com.weather.app.api.Api
import com.weather.app.mvp.Presenter
import com.weather.app.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

class MainPresenter(private val api: Api) : Presenter<MainView>() {

    @SuppressLint("CheckResult")
    fun loadData() {
        getView()?.showLoading()
        api.getWeatherData(Constants.API_KEY, arrayOf(12, 32, 15, 37, 10))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                for (weather in it.list) {
                    getView()?.setData(it.list)
                }
                getView()?.hideLoading()
                getView()?.showContent()
            }, { t ->
                getView()?.hideLoading()
                when (t) {
                    is IOException -> getView()?.showNetworkError()
                    is HttpException -> getView()?.showApiError()
                }
            })
    }
}