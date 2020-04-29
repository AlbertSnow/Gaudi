package com.sogou.babel.gaudi.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sogou.babel.gaudi.R

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_image)

        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png")
            .into(findViewById<ImageView>(R.id.image_iv))
    }
}
