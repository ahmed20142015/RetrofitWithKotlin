package com.example.ahmedpc.retrofitwithkotlin.main

import android.util.Log
import android.widget.Toast
import com.example.ahmedpc.retrofitwithkotlin.adapter.CategoryAdapter
import com.example.ahmedpc.retrofitwithkotlin.model.Category
import com.example.ahmedpc.retrofitwithkotlin.model.CategoryResponse
import com.example.ahmedpc.retrofitwithkotlin.network.ApiInterface
import com.example.ahmedpc.retrofitwithkotlin.network.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainPresenterImp:MainPresenter {

    lateinit var mainView:MainView

    override fun setView(mainView: MainView) {
        this.mainView = mainView
    }
    override fun getCategories() {

        mainView.showLoader()

        val service = RetrofitInstance.getRetrofitInstance()?.create(ApiInterface::class.java)
        val call = service!!.getCategoryDetails()
        Log.d("REQUEST", call.toString() + "")
        call.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: retrofit2.Response<CategoryResponse>?) {
                if (response != null) {
                    mainView.hideLoader()
                    var list: ArrayList<Category> = response.body()!!.categories!!
                    Log.d("MainActivity", "" + list.size)
                    var msg: String = ""
                    for (item: Category in list.iterator()) {
                        msg = msg + item.title + "\n"
                    }

                    mainView.setCategoriesList(list)
                }

                else
                    mainView.hideLoader()

            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
              mainView.hideLoader()
            }
        })

    }


}