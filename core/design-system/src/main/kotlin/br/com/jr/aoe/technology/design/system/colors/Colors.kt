package br.com.jr.aoe.technology.design.system.colors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class Colors(
    primary: Color,
    secondary: Color,
    background: Color,
    text: Color
) {
    var primary by mutableStateOf(value = primary)
        private set

    var secondary by mutableStateOf(value = secondary)
        private set

    var background by mutableStateOf(value = background)
        private set

    var text by mutableStateOf(value = text)
        private set

    fun copy(
        primary: Color = this.primary,
        secondary: Color = this.secondary,
        background: Color = this.background,
        text: Color = this.text
    ) = Colors(
        primary = primary,
        secondary = secondary,
        background = background,
        text = text
    )

    fun updateColorsFrom(other: Colors) {
        primary = other.primary
        secondary = other.secondary
        background = other.background
        text = other.text
    }
}
