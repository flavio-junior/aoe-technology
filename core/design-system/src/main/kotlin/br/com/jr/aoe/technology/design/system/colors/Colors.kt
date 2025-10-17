package br.com.jr.aoe.technology.design.system.colors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class Colors(
    primary: Color,
    secondary: Color,
    background: Color,
    dartText: Color,
    lightText: Color,
    icon: Color,
    inputText: Color,
    inputBackground: Color,
    error: Color
) {
    var primary by mutableStateOf(value = primary)
        private set

    var secondary by mutableStateOf(value = secondary)
        private set

    var background by mutableStateOf(value = background)
        private set

    var darkText by mutableStateOf(value = dartText)
        private set

    var lightText by mutableStateOf(value = lightText)
        private set

    var inputBackground by mutableStateOf(value = inputBackground)
        private set

    var icon by mutableStateOf(value = icon)
        private set

    var inputText by mutableStateOf(value = inputText)
        private set

    var error by mutableStateOf(value = error)

    fun copy(
        primary: Color = this.primary,
        secondary: Color = this.secondary,
        background: Color = this.background,
        darkText: Color = this.darkText,
        lightText: Color = this.lightText,
        icon: Color = this.icon,
        inputText: Color = this.inputText,
        error: Color = this.error
    ) = Colors(
        primary = primary,
        secondary = secondary,
        background = background,
        dartText = darkText,
        lightText = lightText,
        icon = icon,
        inputText = inputText,
        inputBackground = inputBackground,
        error = error
    )

    fun updateColorsFrom(other: Colors) {
        primary = other.primary
        secondary = other.secondary
        background = other.background
        darkText = other.darkText
        lightText = other.lightText
        icon = other.icon
        inputText = other.inputText
        inputBackground = other.inputBackground
        error = other.error
    }
}
