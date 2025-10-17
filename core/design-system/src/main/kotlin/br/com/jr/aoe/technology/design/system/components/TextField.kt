package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import br.com.jr.aoe.technology.design.system.factory.IconName
import br.com.jr.aoe.technology.design.system.settings.Settings
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.design.system.typography.Typography

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String,
    value: String? = null,
    iconName: IconName? = null,
    backgroundColor: Color = Themes.colors.inputBackground,
    textColor: Color = Themes.colors.inputText,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = true,
    isError: Boolean = false,
    message: String? = Settings.EMPTY_TEXT,
    onValueChange: (String) -> Unit = {},
    onGo: () -> Unit = {}
) {
    if (iconName != null) {
        TextFieldWithIcon(
            modifier = modifier,
            enabled = enabled,
            label = label,
            value = value,
            iconName = iconName,
            backgroundColor = backgroundColor,
            textColor = textColor,
            keyboardType = keyboardType,
            imeAction = imeAction,
            maxLines = maxLines,
            singleLine = singleLine,
            isError = isError,
            message = message,
            onValueChange = onValueChange,
            onGo = onGo
        )
    } else {
        TextFieldWithoutIcon(
            modifier = modifier,
            enabled = enabled,
            label = label,
            value = value,
            backgroundColor = backgroundColor,
            textColor = textColor,
            keyboardType = keyboardType,
            imeAction = imeAction,
            maxLines = maxLines,
            singleLine = singleLine,
            isError = isError,
            message = message,
            onValueChange = onValueChange,
            onGo = onGo
        )
    }
}

@Composable
private fun TextFieldWithIcon(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String,
    value: String? = null,
    iconName: IconName,
    backgroundColor: Color,
    textColor: Color,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = true,
    isError: Boolean = false,
    message: String? = Settings.EMPTY_TEXT,
    onValueChange: (String) -> Unit = {},
    onGo: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize8)
    ) {
        OutlinedTextField(
            enabled = enabled,
            value = value ?: Settings.EMPTY_TEXT,
            onValueChange = {
                onValueChange(it)
            },
            maxLines = maxLines,
            singleLine = singleLine,
            label = {
                Description(label = label, color = textColor)
            },
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                IconDefault(iconName = iconName)
            },
            textStyle = Typography(color = textColor).simpleText(),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onGo = { onGo() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                cursorColor = Themes.colors.primary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(size = Themes.size.spaceSize12)
        )
        IsErrorMessage(isError = isError, message = message)
    }
}

@Composable
private fun TextFieldWithoutIcon(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String,
    value: String? = null,
    backgroundColor: Color,
    textColor: Color,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = true,
    isError: Boolean = false,
    message: String? = Settings.EMPTY_TEXT,
    onValueChange: (String) -> Unit = {},
    onGo: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize8)
    ) {
        OutlinedTextField(
            enabled = enabled,
            value = value ?: Settings.EMPTY_TEXT,
            onValueChange = {
                onValueChange(it)
            },
            maxLines = maxLines,
            singleLine = singleLine,
            label = {
                InfoText(label = label, color = textColor)
            },
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            textStyle = Typography(color = textColor).simpleText(),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onGo = { onGo() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                cursorColor = textColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(size = Themes.size.spaceSize12)
        )
        IsErrorMessage(isError = isError, message = message)
    }
}
