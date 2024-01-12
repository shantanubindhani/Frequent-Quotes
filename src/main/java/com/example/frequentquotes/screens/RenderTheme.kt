package com.example.frequentquotes.screens

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import com.example.frequentquotes.ui.theme.AppColors
import com.example.frequentquotes.ui.theme.ThemeManager


//@Preview(name = "theme button", showSystemUi = true)
@Composable
fun RenderTheme(onChange:()->Unit) {
    var appColor : AppColors = ThemeManager.currentTheme
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
        onCheckedChange = { onChange() },
    )
}