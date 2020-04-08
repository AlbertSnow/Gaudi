package com.sogou.babel.gaudi.retrofit.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

const val TAG  = "RetrofitTag"
object  Retrofits {

    suspend fun MyRetrofits() = withContext(Dispatchers.IO){
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.129.43.201:8080")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
        val myInterface = retrofit.create(MyInterface::class.java)
        val call = myInterface.getCall()
        call.enqueue(object: Callback<MyResponse> {

            override fun onFailure(call: Call<MyResponse>, t: Throwable) {
                Log.i(TAG, "Failure: ${t.message}")

            }

            override fun onResponse(call: Call<MyResponse>, response: Response<MyResponse>) {
                Log.i(TAG, "Response: ${response.body()}")
            }

        })
    }

}