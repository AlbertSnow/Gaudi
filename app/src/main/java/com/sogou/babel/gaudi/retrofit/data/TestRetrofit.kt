package com.sogou.babel.gaudi.retrofit.data

import com.sogou.babel.gaudi.data.Retrofits
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun getMyResponse() : Response<MyResponse> = withContext(Dispatchers.IO){

    val myInterface = Retrofits.mainRetrofit.create(MyInterface::class.java)
    val call = myInterface.getCall()
    val result = call.execute()
    return@withContext result

}