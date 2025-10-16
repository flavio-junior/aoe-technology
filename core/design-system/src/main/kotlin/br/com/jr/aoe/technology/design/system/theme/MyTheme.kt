package br.com.jr.aoe.technology.design.system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import br.com.jr.aoe.technology.design.system.components.ProvideTextStyleDefault
import br.com.jr.aoe.technology.design.system.colors.Colors
import br.com.jr.aoe.technology.design.system.colors.DarkColor
import br.com.jr.aoe.technology.design.system.colors.LightColor
import br.com.jr.aoe.technology.design.system.colors.LocalColors
import br.com.jr.aoe.technology.design.system.specifications.LocalSpaces
import br.com.jr.aoe.technology.design.system.specifications.SpaceSize
import br.com.jr.aoe.technology.design.system.theme.Themes.size
import br.com.jr.aoe.technology.design.system.theme.Themes.typography
import br.com.jr.aoe.technology.design.system.typography.LocalTypography
import br.com.jr.aoe.technology.design.system.typography.Typography

@Composable
fun MyTheme(
    content: @Composable () -> Unit
) {
    val isDarkTheme: Boolean = isSystemInDarkTheme()
    val colors: Colors = if (isDarkTheme) DarkColor else LightColor
    val rememberedColorScheme: Colors = remember {
        colors.copy()
    }.apply {
        updateColorsFrom(other = colors)
    }
    CompositionLocalProvider(
        values = arrayOf(
            LocalColors provides rememberedColorScheme,
            LocalSpaces provides size,
            LocalTypography provides typography
        ),
        content = {
            ProvideTextStyleDefault(
                value = Typography().description(),
                content = content
            )
        }
    )
}

object Themes {
    val colors: Colors
        @Composable @ReadOnlyComposable
        get() = LocalColors.current
    val typography: Typography
        @Composable @ReadOnlyComposable
        get() = LocalTypography.current
    val size: SpaceSize
        @Composable @ReadOnlyComposable
        get() = LocalSpaces.current
}
