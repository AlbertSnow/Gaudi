package com.sogou.babel.gaudi

import android.app.Application
import android.content.Context
import com.albert.snow.baselibrary.isForbiddenLog
import com.sogou.babel.gaudi.plug.DexPathListInvocationHandler
import com.sogou.babel.gaudi.plug.PlugClassLoader2
import com.sogou.babel.gaudi.plug.PluginUtil
import java.io.File
import java.lang.reflect.Proxy


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
        heavyPlug(base)
        super.attachBaseContext(base)
    }

    private fun heavyPlug(base: Context) {
        //        copySoFile(base)
        val packageInfo = PluginUtil.getFieldValue(base, "mPackageInfo");
        //        val classLoader = PlugClassLoader("/data/app/com.sogou.babel.gaudi-2/base.apk", base.classLoader)

        val nativeLibraryDir: String = base.filesDir.absolutePath
        val classLoader = PlugClassLoader2(
            "/sdcard/1/app-debug.apk",
            base.getDir("plug_odex", Context.MODE_PRIVATE).absolutePath,
            nativeLibraryDir,
            base.classLoader.parent
        )

        PluginUtil.setFieldValue(
            packageInfo,
            "mClassLoader",
            classLoader
        )

        //        PluginUtil.setField(packageInfo, "mClassLoader", classLoader)
        Thread.currentThread().contextClassLoader = classLoader


        super.attachBaseContext(base)
    }

    private fun copySoFile(context: Context) {

        val sourceFile = File("sdcard/1/libopencv_java3.so")

        val destDir = context.getDir("plug_so", Context.MODE_PRIVATE)
        if (!destDir.exists()) {
            destDir.mkdirs()
        }

//        val destFile = File(destDir, "libopencv_java3.so")
//        if (!destFile.exists()) {
//            destFile.createNewFile()
//        }

        sourceFile.copyTo(destDir, true)
    }

    private fun reflectChangeValue(packageInfo: Any?, customPath: String) {
        val pathClassLoader = PluginUtil.getFieldValue(packageInfo, "mClassLoader")

        val pathListFiled = pathClassLoader.javaClass.superclass?.getDeclaredField("pathList")
        pathListFiled?.isAccessible = true
        val pathListValue = pathListFiled?.get(pathClassLoader)
        val libDirs = pathListValue?.javaClass?.getDeclaredField("nativeLibraryDirectories")
        libDirs?.isAccessible = true
        val libDirsValue = libDirs?.get(pathListValue)
        val libDirsValueArray: ArrayList<File> = libDirsValue as ArrayList<File>
        libDirsValueArray.add(File(customPath))

        val method = pathListValue?.javaClass?.getDeclaredMethod(
            "addNativePath",
            PluginUtil.getCollectionTye()
        )
        method.isAccessible = true
        method.invoke(pathListValue, listOf(customPath))
    }

}