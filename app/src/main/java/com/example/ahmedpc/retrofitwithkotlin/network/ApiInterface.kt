package com.example.ahmedpc.retrofitwithkotlin.network

import com.example.ahmedpc.retrofitwithkotlin.model.CategoryResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiInterface {

    @GET("?json=get_category_index")
    fun getCategoryDetails(): Call<CategoryResponse>

}