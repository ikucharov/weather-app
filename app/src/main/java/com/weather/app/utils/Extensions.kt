package com.weather.app.utils

import android.graphics.Paint
import android.view.View
import android.widget.TextView

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun TextView.setUnderlined() {
    paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
}