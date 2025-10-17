package br.com.jr.aoe.technology.design.system.colors

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val DarkColor = Colors(
    primary = Color(color = 0xFF000000),
    secondary = Color(color = 0xFF358073),
    background = Color(color = 0xFFFAFAFA),
    dartText = Color(color = 0xFF0D141C),
    lightText = Color(color = 0xFFF7FAFC),
    icon = Color(color = 0xFF0D141C),
    inputText = Color(color = 0xFF5C738A),
    inputBackground = Color(color = 0xFFEBEDF2),
    error = Color(color = 0xFFCC1922)
)

val LightColor = Colors(
    primary = Color(color = 0xFF000000),
    secondary = Color(color = 0xFF358073),
    background = Color(color = 0xFFFAFAFA),
    dartText = Color(color = 0xFF0D141C),
    lightText = Color(color = 0xFFF7FAFC),
    icon = Color(color = 0xFF0D141C),
    inputText = Color(color = 0xFF5C738A),
    inputBackground = Color(color = 0xFFEBEDF2),
    error = Color(color = 0xFFCC1922)
)

val LocalColors = staticCompositionLocalOf {
    LightColor
}
