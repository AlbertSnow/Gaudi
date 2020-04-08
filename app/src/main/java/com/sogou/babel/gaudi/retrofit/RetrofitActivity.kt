package com.sogou.babel.gaudi.retrofit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sogou.babel.gaudi.R
import com.sogou.babel.gaudi.databinding.ActivityRetrofitBinding
import com.sogou.babel.gaudi.retrofit.data.RetrofitModel

class RetrofitActivity : AppCompatActivity() {

    lateinit var bingVar: ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingVar = DataBindingUtil.setContentView<ActivityRetrofitBinding>(this, R.layout.activity_retrofit)
        bingVar.viewmodel = RetrofitModel()
        bingVar.lifecycleOwner = this
    }

    fun update(view: View) {
        bingVar.viewmodel?.updateInfor()
    }
}
