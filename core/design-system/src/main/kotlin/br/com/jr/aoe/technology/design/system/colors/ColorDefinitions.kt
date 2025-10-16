package br.com.jr.aoe.technology.design.system.colors

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val DarkColor = Colors(
    primary = Color(color = 0xFF000000),
    secondary = Color(color = 0xFFe8702a),
    background = Color(color = 0xFFf2f2f2),
    text = Color(color = 0xFF000000)
)

val LightColor = Colors(
    primary = Color(color = 0xFF000000),
    secondary = Color(color = 0xFFe8702a),
    background = Color(color = 0xFFf2f2f2),
    text = Color(color = 0xFF000000)
)

val LocalColors = staticCompositionLocalOf {
    LightColor
}
