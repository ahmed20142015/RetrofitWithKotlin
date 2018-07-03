package com.example.ahmedpc.retrofitwithkotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    private constructor()

    companion object Factory {
        private var retrofit: Retrofit? = null
       val BASE_URL = "https://androidteachers.com/"

        fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit

        }


        }

}