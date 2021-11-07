package com.example.retrofit.api

import com.example.retrofit.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//STEP 4
//MAKE SINGLETON CLASS/OBJECT
object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val  api:SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}