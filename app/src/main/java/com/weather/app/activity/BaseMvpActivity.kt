package com.weather.app.activity

import android.app.AlertDialog
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import com.weather.app.App
import com.weather.app.R
import com.weather.app.mvp.BaseView
import com.weather.app.mvp.Presenter
import com.weather.app.mvp.activity.MvpActivity
import com.weather.app.utils.PreferencesUtil
import javax.inject.Inject

abstract class BaseMvpActivity<V : BaseView, P : Presenter<V>> : MvpActivity<V, P>() {

    @Inject
    lateinit var preferencesUtil: PreferencesUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        dependencyInject()
        super.onCreate(savedInstanceState)
    }

    fun setHomeAsUp() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (!super.onSupportNavigateUp()) {
            supportFinishAfterTransition()
        }
        return true
    }

    fun showNoNetworkAlert() {
        showAlert(R.string.no_internet)
    }

    fun showAlert(message: String) {
        showAlert(null, message)
    }

    fun showAlert(@StringRes messageRes: Int) {
        showAlert(null, getString(messageRes))
    }

    fun showAlert(title: String?, message: String?) {
        if (isFinishing.not()) {
            AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("ok", null)
                .show()
        }
    }

    fun showToast(@StringRes messageRes: Int) {
        Toast.makeText(this, messageRes, Toast.LENGTH_SHORT).show()
    }

    fun showToast(toastMessage: String) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }

    fun hideKeyboard() {
        // Check if no view has focus:
        this.currentFocus?.let {
            it.clearFocus()
            val imm: InputMethodManager? = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    fun getApp(): App {
        return application as App
    }

    abstract fun dependencyInject()
}