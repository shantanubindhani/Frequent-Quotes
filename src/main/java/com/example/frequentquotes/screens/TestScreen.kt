//package com.example.frequentquotes.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.FormatQuote
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Divider
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.rotate
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.frequentquotes.model.Quote
//import com.example.frequentquotes.ui.theme.AppColors
//import com.example.frequentquotes.ui.theme.AppTheme
//import com.example.frequentquotes.ui.theme.DarkThemeColors
//import com.example.frequentquotes.ui.theme.LightThemeColors
//
//@Preview(name = "Quote detail preview", showSystemUi = true)
//@Composable
//fun QuoteDetail(quote : Quote? = Quote("Try Again!", "coder"), appColors:AppColors = LightThemeColors) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .fillMaxSize(1f)
//            .clickable {}
//            .background(
//                brush = Brush.verticalGradient(
//                    colors = listOf(
//                        appColors.gray,
//                        appColors.background,
//                        appColors.background
//                    )
//                )
//            )
//            .padding(20.dp)
//    ){
//        Card(
//            elevation = CardDefaults.cardElevation(10.dp),
//            colors = CardDefaults.cardColors(appColors.card),
//            modifier = Modifier.padding(10.dp)
//        ){
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.padding(10.dp)
//            ) {
//                Divider(
//                    color = appColors.gray,
//                    modifier = Modifier
//                        .height(5.dp)
//                        .align(Alignment.Start)
//                        .fillMaxSize(0.25f)
//                )
//                Image(
//                    imageVector = Icons.Filled.FormatQuote,
//                    contentDescription = "quote",
//                    colorFilter = ColorFilter.tint(appColors.subText),
//                    modifier = Modifier
//                        .size(50.dp)
//                        .rotate(180f)
//                )
//                Text(
//                    "\"${quote?.quote}\"",
//                    style = MaterialTheme.typography.labelMedium,
//                    color = appColors.text,
//                    fontSize = 25.sp,
//                    textAlign = TextAlign.Center,
//                    fontStyle = FontStyle.Italic,
//                    lineHeight = 27.sp,
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )
//                Divider(
//                    Modifier
//                        .height(1.dp)
//                        .fillMaxSize(0.5f)
//                        .background(color = appColors.gray)
//                )
//                Text(
//                    " ~ ${quote?.author}",
//                    Modifier.padding(bottom = 10.dp),
//                    color = appColors.subText
//                )
//                Divider(
//                    color = appColors.gray,
//                    modifier = Modifier
//                        .height(5.dp)
//                        .align(Alignment.End)
//                        .fillMaxSize(0.25f)
//                )
//            }
//        }
//
//    }
//}