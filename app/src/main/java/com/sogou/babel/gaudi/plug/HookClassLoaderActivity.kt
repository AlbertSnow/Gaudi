package com.sogou.babel.gaudi.plug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sogou.babel.gaudi.R
import com.sogou.babel.gaudi.plug.data.LoadSoClass
import java.lang.Exception

class HookClassLoaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hook_classs_loader)
        val loadTest = LoadSoClass()
    }

    fun loadSoLibrary(view: View)  {
        try {
            System.loadLibrary("opencv_java3")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
