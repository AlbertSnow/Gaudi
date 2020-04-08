package com.sogou.babel.gaudi.retrofit.data

import retrofit2.Call
import retrofit2.http.GET

interface MyInterface {

    @GET("/")
    fun getCall(): Call<MyResponse>

}