package com.sogou.babel.gaudi

import android.util.Log
import android.view.View
import android.widget.ProgressBar

import androidx.databinding.BindingAdapter


@BindingAdapter(value = ["app:hideIfZero", "android:max"], requireAll = true)
    fun hideIfZero(view: ProgressBar, number: Int, max: Int) {
        view.visibility = if (number == 0) View.INVISIBLE else View.VISIBLE
        view.progress = number
        Log.i("testView", "max value: $max")
    }