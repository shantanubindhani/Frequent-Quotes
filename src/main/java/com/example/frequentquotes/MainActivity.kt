package com.example.frequentquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frequentquotes.screens.Home
import com.example.frequentquotes.screens.QuoteDetail
import com.example.frequentquotes.screens.RenderTheme
import com.example.frequentquotes.ui.theme.AppTheme
import com.example.frequentquotes.ui.theme.DataManager
import com.example.frequentquotes.ui.theme.ThemeManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            DataManager.loadAssetsFromFile(context = applicationContext)
        }
        ThemeManager.init()
        setContent {
            App()
        }
    }
}

//@Composable
//fun loading() {
//    var loading = listOf<String>(
//        ":.............",
//        "::............",
//        ":::...........",
//        "::::..........",
//        ":::::.........",
//        "::::::........",
//        ":::::::.......",
//        "::::::::......",
//        "::::::::::.....",
//        ":::::::::::....",
//        "::::::::::::...",
//        ":::::::::::::..",
//        "::::::::::::::.",
//        ":::::::::::::::",
//    )
//    var index = remember { mutableStateOf(0) }
//    Box() {
//        Text(
//            loading[index.value],
//            textAlign = TextAlign.Center,
//            fontSize = 40.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier
//                .padding(8.dp, 14.dp)
//                .fillMaxWidth(1f),
//            style = MaterialTheme.typography.headlineSmall
//        )
//        for (i in 1..1000) {
//            index.value = (index.value + 1) % 14
//        }
//    }
//}

enum class Pages{
    QuoteHome,
    QuoteDetail
}

@Composable
fun App() {
    var appColor = ThemeManager.currentTheme;
    if (!DataManager.isEmpty.value) {
        if(DataManager.currentPage.value == Pages.QuoteHome) {
            Home(data = DataManager.data, appColor){
                DataManager.switchPages(it)
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(5.dp).padding(top = 10.dp)
            ){
                Switch(
                    modifier = Modifier
                        .rotate(270f)
                        .scale(1.09f),
                    checked = ThemeManager.checked.value,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = appColor.background,
                        checkedTrackColor = appColor.subText,
                        uncheckedThumbColor = appColor.subText,
                        uncheckedTrackColor = appColor.background,

                        ),
                    onCheckedChange = { ThemeManager.changeTheme() },
                )
            }
        }
        else{
            QuoteDetail(quote = DataManager.currentQuote, appColor){
                DataManager.switchPages()
            }
        }
    } else {
        Text(
            "L o A d I n G . . .",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp, 14.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
