package com.sogou.babel.gaudi

import android.app.Application
import android.content.Context
import com.albert.snow.baselibrary.isForbiddenLog
import com.sogou.babel.gaudi.plug.PlugClassLoader
import com.sogou.babel.gaudi.plug.PluginUtil
import java.io.File


lateinit var application : MyApplication
class MyApplication : Application() {

    init {
        application = this
    }

    override fun onCreate() {
        super.onCreate()
        isForbiddenLog = !BuildConfig.DEBUG
    }


    override fun attachBaseContext(base: Context) {
//        val dexPath: String = PluginUtil.getField(base, "originalPath") as String;
        val packageInfo = PluginUtil.getField(base, "mPackageInfo");
//        val classLoader = PlugClassLoader("/data/app/com.sogou.babel.gaudi-2/base.apk", base.classLoader)
//
//        PluginUtil.setField(packageInfo, "mClassLoader", classLoader)
//        Thread.currentThread().contextClassLoader = classLoader

        val pathClassLoader = PluginUtil.getField(packageInfo, "mClassLoader")

        val pathListFiled = pathClassLoader.javaClass.superclass?.getDeclaredField("pathList")
        pathListFiled?.isAccessible = true
        val pathListValue = pathListFiled?.get(pathClassLoader)
        val libDirs = pathListValue?.javaClass?.getDeclaredField("nativeLibraryDirectories")
        libDirs?.isAccessible = true
        val libDirsValue = libDirs?.get(pathListValue)
        val libDirsValueArray: ArrayList<File> = libDirsValue as ArrayList<File>
        libDirsValueArray.add(File("/sdcard/lib/arm64"))

        super.attachBaseContext(base)
    }

}