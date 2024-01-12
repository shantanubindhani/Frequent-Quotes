package com.example.frequentquotes.ui.theme

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.frequentquotes.Pages
import com.example.frequentquotes.model.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    var isEmpty = mutableStateOf(true)

    var currentPage = mutableStateOf(Pages.QuoteHome)
    var currentQuote : Quote? = null

    fun loadAssetsFromFile(context : Context){
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,  Array<Quote>::class.java)
        isEmpty.value = false
    }

    fun switchPages(quote : Quote? = null){
        currentQuote = quote
        if(currentPage.value == Pages.QuoteHome){
            currentPage.value = Pages.QuoteDetail
        }else{
            currentPage.value = Pages.QuoteHome
        }
    }
}