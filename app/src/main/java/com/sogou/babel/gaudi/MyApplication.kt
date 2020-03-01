package com.sogou.babel.gaudi

import android.app.Application
import com.albert.snow.baselibrary.isDebug

lateinit var application : MyApplication
class MyApplication : Application() {

    init {
        application = this
    }

    override fun onCreate() {
        super.onCreate()
        isDebug = BuildConfig.DEBUG
    }

}