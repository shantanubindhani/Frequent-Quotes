package com.example.frequentquotes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frequentquotes.model.Quote
import com.example.frequentquotes.ui.theme.AppColors
import com.example.frequentquotes.ui.theme.DataManager
import com.example.frequentquotes.ui.theme.LightThemeColors

//@Preview(name = "Quote list item preview", showSystemUi = true)
@Composable
fun QuoteListItem(quote : Quote, onClick: (quote: Quote)->Unit, appColors: AppColors = LightThemeColors) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(appColors.card),
        modifier = Modifier
            .clickable { onClick(quote) }
            .padding(10.dp)
    ){
        Row(
            Modifier.padding(10.dp)
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                alignment = Alignment.TopStart,
                contentDescription = "quote",
                colorFilter = ColorFilter.tint(appColors.card),
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
                    .background(appColors.subText)
                    .padding(top = 5.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    quote.quote,
                    fontSize = 17.sp,
                    color = appColors.text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 12.dp)
                )
                Divider(Modifier.size(width = 250.dp, height = 1.dp))
                Text(
                    "~ ${quote.author}",
                    color = appColors.subText,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }
        }
    }
}


