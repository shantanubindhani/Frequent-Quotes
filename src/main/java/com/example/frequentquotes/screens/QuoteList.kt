package com.example.frequentquotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.frequentquotes.model.Quote
import com.example.frequentquotes.ui.theme.AppColors
import com.example.frequentquotes.ui.theme.LightThemeColors

@Composable
fun QuoteList(data : Array<Quote>, onClick : (quote: Quote)->Unit, appColors: AppColors = LightThemeColors){
    LazyColumn() {
        items(data){    
            QuoteListItem(quote = it, onClick, appColors)
        }
    }

}