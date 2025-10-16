package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import br.com.jr.aoe.technology.design.system.factory.IconName
import br.com.jr.aoe.technology.design.system.forms.onClickable
import br.com.jr.aoe.technology.design.system.resources.getIconResource
import br.com.jr.aoe.technology.design.system.settings.Settings
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.design.system.typography.Typography

@Composable
fun TextPassword(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    imeAction: ImeAction = ImeAction.Go,
    isError: Boolean = false,
    message: String? = Settings.EMPTY_TEXT,
    onValueChange: (String) -> Unit,
    onGo: () -> Unit = {}
) {
    var passwordHidden: Boolean by rememberSaveable { mutableStateOf(value = true) }
    Column(
        modifier = modifier
            .background(color = Themes.colors.background)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize8)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = Typography(color = Themes.colors.primary).simpleText(),
            singleLine = true,
            label = {
                Description(label = label)
            },
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            leadingIcon = {
                Icon(
                    painter = getIconResource(iconName = IconName.LOCK),
                    contentDescription = Settings.EMPTY_TEXT
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(onGo = {
                onGo()
            }),
            trailingIcon = {
                Icon(
                    painter = if (passwordHidden) getIconResource(iconName = IconName.VISIBILITY)
                    else getIconResource(iconName = IconName.VISIBILITY_OFF),
                    contentDescription = Settings.EMPTY_TEXT,
                    modifier = Modifier.onClickable(onClick = {
                        passwordHidden = !passwordHidden
                    })
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Themes.colors.background,
                cursorColor = Themes.colors.primary,
                focusedIndicatorColor = Themes.colors.primary,
                unfocusedIndicatorColor = Themes.colors.primary
            ),
            shape = RoundedCornerShape(size = Themes.size.spaceSize16)
        )
        IsErrorMessage(isError = isError, message = message)
    }
}
