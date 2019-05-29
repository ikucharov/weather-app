package com.weather.app.activity.main

import android.os.Bundle
import com.weather.app.App
import com.weather.app.R
import com.weather.app.activity.BaseMvpActivity
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseMvpActivity<MainView, MainPresenter>(), MainView {

    @Inject
    lateinit var presenterProvider: Lazy<MainPresenter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = ""

        setSupportActionBar(toolbar)

    }

    override fun dependencyInject() {
        App.getPresenterComponent().inject(this)
    }

    override fun createPresenter(): MainPresenter = presenterProvider.get()

    override fun getMvpView(): MainView = this
}