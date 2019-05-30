package com.weather.app.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weather.app.App
import com.weather.app.R
import com.weather.app.activity.BaseMvpActivity
import com.weather.app.activity.details.WeatherDetailsActivity
import com.weather.app.model.WeatherData
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class MainActivity : BaseMvpActivity<MainView, MainPresenter>(), MainView {

    @Inject
    lateinit var presenterProvider: Lazy<MainPresenter>

    private val adapter = WeatherAdapter()
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        title = resources.getString(R.string.app_name)

        presenter.loadData()

        faqRecyclerView.layoutManager = GridLayoutManager(this, 1)
        faqRecyclerView.adapter = adapter
        faqRecyclerView.setHasFixedSize(true)

        layoutManager = faqRecyclerView.layoutManager

        errorView.setCompoundDrawablesWithIntrinsicBounds(
            null,
            AppCompatResources.getDrawable(this, R.drawable.ic_refresh_black),
            null,
            null
        )

        errorView.setOnClickListener {
            presenter.loadData()
        }
    }

    override fun setData(data: List<WeatherData>) {
        adapter.setData(data)
    }

    override fun showLoading() {
        progressView.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressView.visibility = View.GONE
    }

    override fun showContent() {
        faqRecyclerView.visibility = View.VISIBLE
    }

    override fun hideContent() {
        faqRecyclerView.visibility = View.GONE
    }

    override fun showApiError() {
        errorView.visibility = View.VISIBLE
        errorView.setText(R.string.unknown_error_occurred_try_later)
    }

    override fun showNetworkError() {
        errorView.visibility = View.VISIBLE
        errorView.setText(R.string.no_internet)
    }

    override fun hideRefreshView() {
        errorView.visibility = View.GONE
    }

    override fun dependencyInject() {
        App.getPresenterComponent().inject(this)
    }

    override fun createPresenter(): MainPresenter = presenterProvider.get()

    override fun getMvpView(): MainView = this
}