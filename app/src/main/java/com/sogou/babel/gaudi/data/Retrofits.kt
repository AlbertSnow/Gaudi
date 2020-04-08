package com.sogou.babel.gaudi.data

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

const val TAG  = "RetrofitTag"
object  Retrofits {
    val  mainRetrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.129.43.201:8080")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

}