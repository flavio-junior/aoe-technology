package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.jr.aoe.technology.design.system.settings.Settings
import br.com.jr.aoe.technology.design.system.specifications.TypeFont
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.design.system.typography.Typography

@Composable
fun Title(
    modifier: Modifier = Modifier,
    color: Color = Themes.colors.primary,
    typeFont: TypeFont? = null,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    label: String? = null
) {
    BasicText(
        text = label ?: Settings.EMPTY_TEXT,
        modifier = modifier,
        style = Typography(
            color = color,
            textAlign = textAlign,
            typeFont = typeFont
        ).title(),
        maxLines = maxLines
    )
}

@Composable
fun SubTitle(
    modifier: Modifier = Modifier,
    color: Color = Themes.colors.primary,
    label: String? = null,
    typeFont: TypeFont? = null,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Start
) {
    BasicText(
        text = label ?: Settings.EMPTY_TEXT,
        modifier = modifier,
        style = Typography(
            color = color,
            textAlign = textAlign,
            typeFont = typeFont
        ).subTitle(),
        maxLines = maxLines
    )
}

@Composable
fun Description(
    modifier: Modifier = Modifier,
    label: String? = null,
    color: Color = Themes.colors.primary,
    typeFont: TypeFont? = null,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Start
) {
    BasicText(
        text = label ?: Settings.EMPTY_TEXT,
        modifier = modifier,
        style = Typography(
            color = color,
            textAlign = textAlign,
            typeFont = typeFont
        ).description(),
        maxLines = maxLines
    )
}

@Composable
fun InfoText(
    modifier: Modifier = Modifier,
    color: Color = Themes.colors.primary,
    label: String? = null,
    typeFont: TypeFont? = null,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Start
) {
    BasicText(
        text = label ?: Settings.EMPTY_TEXT,
        modifier = modifier,
        style = Typography(
            color = color,
            textAlign = textAlign,
            typeFont = typeFont
        ).infoText(),
        maxLines = maxLines
    )
}

@Composable
@Preview
private fun ShowTextPreview() {
    Title(label = "Test")
}

val LocalTextStyleDefault = compositionLocalOf(policy = structuralEqualityPolicy()) {
    TextStyle.Default
}

@Composable
fun ProvideTextStyleDefault(
    value: TextStyle,
    content: @Composable () -> Unit = {}
) {
    val mergedStyle: TextStyle = LocalTextStyleDefault.current.merge(other = value)
    CompositionLocalProvider(
        value = LocalTextStyleDefault provides mergedStyle,
        content = content
    )
}
