package com.example.ahmedpc.retrofitwithkotlin.main

import com.example.ahmedpc.retrofitwithkotlin.model.Category

interface MainView {

    fun showLoader()
    fun hideLoader()
    fun setCategoriesList(categories:ArrayList<Category>)
}