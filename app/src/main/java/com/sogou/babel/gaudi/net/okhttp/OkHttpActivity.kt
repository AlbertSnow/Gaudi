package com.sogou.babel.gaudi.net.okhttp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.albert.snow.baselibrary.AlbertLog
import com.sogou.babel.gaudi.R

import kotlinx.android.synthetic.main.activity_ok_http.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class OkHttpActivity : AppCompatActivity(), Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            requestOkHttp()
        }
    }

    private fun requestOkHttp() {
        val request = Request.Builder().url("https://www.baidu.com").build()
        NetClient.okHttp.newCall(request).enqueue(this)
    }

    override fun onFailure(call: Call, e: IOException) {
        AlbertLog.e("request Failure")
    }

    override fun onResponse(call: Call, response: Response) {
        AlbertLog.i("onResponse ${response.body}")
        runOnUiThread {
            Toast.makeText(this, "Body: ${response.body}", Toast.LENGTH_SHORT).show()
        }
    }

}
