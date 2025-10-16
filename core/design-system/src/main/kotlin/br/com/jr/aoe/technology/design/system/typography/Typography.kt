package br.com.jr.aoe.technology.design.system.typography

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import br.com.jr.aoe.technology.design.system.R
import br.com.jr.aoe.technology.design.system.specifications.FontSize
import br.com.jr.aoe.technology.design.system.specifications.TypeFont

data class Typography(
    val color: Color = Color.Black,
    val textAlign: TextAlign = TextAlign.Start,
    val typeFont: TypeFont? = null
) {

    @Composable
    fun title() = TextStyle(
        color = color,
        fontSize = FontSize.fontSize32,
        fontWeight = FontWeight.SemiBold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.BOLD),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    @Composable
    fun subTitle() = TextStyle(
        color = color,
        fontSize = FontSize.fontSize24,
        fontWeight = FontWeight.Medium,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.MEDIUM),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    @Composable
    fun description() = TextStyle(
        color = color,
        fontSize = FontSize.fontSize20,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.REGULAR),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    @Composable
    fun simpleText(): TextStyle = TextStyle(
        color = color,
        fontSize = FontSize.fontSize16,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.REGULAR),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    @Composable
    fun infoText() = TextStyle(
        color = color,
        fontSize = FontSize.fontSize14,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.BOLD),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    @Composable
    fun smallText() = TextStyle(
        color = color,
        fontSize = FontSize.fontSize12,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.BOLD),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    @Composable
    fun miniText() = TextStyle(
        color = color,
        fontSize = FontSize.fontSize8,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.BOLD),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )
}

val LocalTypography = staticCompositionLocalOf {
    Typography()
}

@Composable
private fun selectFontFamily(typeFont: TypeFont): FontFamily {
    return when (typeFont) {
        TypeFont.BOLD -> FontFamily(Font(resId = R.font.nunito_bold))
        TypeFont.MEDIUM -> FontFamily(Font(resId = R.font.nunito_medium))
        TypeFont.REGULAR -> FontFamily(Font(resId = R.font.nunito_regular))
    }
}
