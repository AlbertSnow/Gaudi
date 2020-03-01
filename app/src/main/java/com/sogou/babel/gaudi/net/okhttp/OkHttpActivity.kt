package com.sogou.babel.gaudi.net.okhttp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sogou.babel.gaudi.R

import kotlinx.android.synthetic.main.activity_ok_http.*

class OkHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            requestOkHttp()
        }
    }

    private fun requestOkHttp() {


    }

}
