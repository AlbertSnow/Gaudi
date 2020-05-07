package com.sogou.babel.gaudi.view.text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.widget.TextView
import com.sogou.babel.gaudi.R

class CustomTextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_text_view)
        initView()
    }

    private fun initView() {
        val text = handleText()
        findViewById<TextView>(R.id.custom_text_view).setText(
            handleText()
        )

    }

    private fun handleText(): Spannable {
        var msg = SpannableString("Hello World, My Name is ZhaoJialiang")
        return msg
    }


}
