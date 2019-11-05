package com.sogou.babel.gaudi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sogou.babel.gaudi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bingVar = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        bingVar.firstName = "Albert"
        bingVar.secondName = "Snow"
    }
}
