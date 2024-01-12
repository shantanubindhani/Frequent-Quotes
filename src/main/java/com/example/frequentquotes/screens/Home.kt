package com.example.frequentquotes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.frequentquotes.model.Quote
import com.example.frequentquotes.ui.theme.AppColors
import com.example.frequentquotes.ui.theme.LightThemeColors
import com.example.frequentquotes.ui.theme.ThemeManager

//@Preview(name = "App Home", showSystemUi = true)
@Composable
fun header(appColor: AppColors = LightThemeColors) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            ". : Q u o t e s : .",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = appColor.text,
            modifier = Modifier
                .padding(8.dp, 14.dp)
                .fillMaxWidth(0.9f),
            style = MaterialTheme.typography.headlineSmall
        )
        Divider(
            Modifier
                .height(2.dp)
                .fillMaxSize(0.7f), color = appColor.text
        )
    }

}

@Composable
fun Home(
    data: Array<Quote>,
    appColor: AppColors = LightThemeColors,
    onClick: (quote: Quote) -> Unit
) {
    Column(Modifier.background(color = appColor.background)) {
        header(appColor)//, onChange)
        QuoteList(data = data, onClick, appColor)
    }
}
