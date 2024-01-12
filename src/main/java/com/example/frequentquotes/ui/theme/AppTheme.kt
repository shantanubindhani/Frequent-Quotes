package com.example.frequentquotes.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

enum class AppTheme{
    Light,
    Dark
}
open class AppColors(){
    open val text = Color(0xFF1A1A1A)
    open val subText = Color(0xFF414141)
    open val background = Color(0xFFEBEAEA)
    open val gray = Color(0xFF8A8A8A)
    open val shadow = Color(0xFF2B2B2B)
    open val card = Color(0xFFEFFAF8)
}
object LightThemeColors: AppColors() { }

object DarkThemeColors: AppColors() {
    override val text = Color(0xFFDEDFDF)
    override val subText = Color(0xFFB6B5B5)
    override val background = Color(0xFF383838)
    override val gray = Color(0xFF8A8989)
    override val shadow = Color(0xFFCCCCCC)
    override val card = Color(0xFF27242C)
}

object ThemeManager{
    var theme = mutableStateOf(AppTheme.Light)
    var currentTheme : AppColors = LightThemeColors
    var checked = mutableStateOf(true)

    fun init(){
        currentTheme = DarkThemeColors
        checked.value = false
        theme.value = AppTheme.Dark
    }

    fun changeTheme(){
        if(theme.value == AppTheme.Light){
            currentTheme = DarkThemeColors
            theme.value = AppTheme.Dark
            checked.value = false
        }
        else {
            currentTheme = LightThemeColors
            theme.value = AppTheme.Light
            checked.value = true
        }
    }

}