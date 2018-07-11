package com.example.ahmedpc.retrofitwithkotlin.main

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.ahmedpc.retrofitwithkotlin.R
import com.example.ahmedpc.retrofitwithkotlin.adapter.CategoryAdapter
import com.example.ahmedpc.retrofitwithkotlin.model.Category
import com.example.ahmedpc.retrofitwithkotlin.model.CategoryResponse
import com.example.ahmedpc.retrofitwithkotlin.network.ApiInterface
import com.example.ahmedpc.retrofitwithkotlin.network.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity(),MainView {

    lateinit var context:Context
    lateinit var pDialog: ProgressDialog
    lateinit var presenter:MainPresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        presenter = MainPresenterImp()
        presenter.setView(this)
        rv_category_list.layoutManager = LinearLayoutManager(this)
        presenter.getCategories()

    }

    override fun showLoader() {
        pDialog = ProgressDialog(this@MainActivity)
        pDialog!!.setMessage("Loading..")
        pDialog!!.setCancelable(false)
        pDialog!!.isIndeterminate = false
        pDialog!!.show()
    }

    override fun hideLoader() {
        if (pDialog != null && pDialog!!.isShowing()) {
            pDialog.dismiss()
        }
    }

    override fun setCategoriesList(categories: ArrayList<Category>) {
        rv_category_list.adapter = CategoryAdapter(categories, context)
    }



}
