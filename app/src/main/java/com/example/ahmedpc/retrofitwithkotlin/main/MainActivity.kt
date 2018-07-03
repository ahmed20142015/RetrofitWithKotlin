package com.example.ahmedpc.retrofitwithkotlin.main

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ahmedpc.retrofitwithkotlin.R
import com.example.ahmedpc.retrofitwithkotlin.model.Category
import com.example.ahmedpc.retrofitwithkotlin.model.CategoryResponse
import com.example.ahmedpc.retrofitwithkotlin.network.ApiInterface
import com.example.ahmedpc.retrofitwithkotlin.network.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DisplayProgressDialog()
        callWebService()
    }


    fun callWebService() {
        val service = RetrofitInstance.getRetrofitInstance()?.create(ApiInterface::class.java)
        val call = service!!.getCategoryDetails()
        Log.d("REQUEST", call.toString() + "")
        call.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: retrofit2.Response<CategoryResponse>?) {
                if (response != null) {
                    if (pDialog != null && pDialog!!.isShowing()) {
                        pDialog.dismiss()
                    }
                    var list: List<Category> = response.body()!!.categories!!
                    Log.d("MainActivity", "" + list.size)
                    var msg: String = ""
                    for (item: Category in list.iterator()) {
                        msg = msg + item.title + "\n"
                    }
                    Toast.makeText(this@MainActivity, "List of Category  \n  " + msg, Toast.LENGTH_LONG).show()
                    txtDisplay.setText(msg + "")
                }

            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                //                Log.e(TAG, t.toString());
                Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()

                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss()
                }
            }
        })
    }
    lateinit var pDialog: ProgressDialog
    fun DisplayProgressDialog() {

        pDialog = ProgressDialog(this@MainActivity)
        pDialog!!.setMessage("Loading..")
        pDialog!!.setCancelable(false)
        pDialog!!.isIndeterminate = false
        pDialog!!.show()
    }
}
