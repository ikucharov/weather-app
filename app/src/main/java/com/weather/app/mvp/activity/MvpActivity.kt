package com.weather.app.mvp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.weather.app.mvp.BaseView
import com.weather.app.mvp.Presenter

/**
 * Base mvp activity
 */
abstract class MvpActivity<V : BaseView, P : Presenter<V>> : AppCompatActivity() {

    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        presenter.attachView(getMvpView())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    abstract fun createPresenter(): P

    abstract fun getMvpView(): V
}
