package br.com.jr.aoe.technology.feature.account.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import br.com.jr.aoe.technology.design.system.components.CommonImage
import br.com.jr.aoe.technology.design.system.components.Header
import br.com.jr.aoe.technology.design.system.components.LoadingButton
import br.com.jr.aoe.technology.design.system.components.TextField
import br.com.jr.aoe.technology.design.system.components.TextPassword
import br.com.jr.aoe.technology.design.system.factory.IconName
import br.com.jr.aoe.technology.design.system.settings.Align
import br.com.jr.aoe.technology.design.system.settings.Settings
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.feature.account.R

@Composable
fun SignInScreen() {
    var email: String by remember { mutableStateOf(value = Settings.EMPTY_TEXT) }
    var password: String by remember { mutableStateOf(value = Settings.EMPTY_TEXT) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(horizontal = Themes.size.spaceSize16)
    ) {
        Header(
            label = stringResource(id = R.string.sign_in),
            align = Align.CENTER
        )
        CommonImage(iconName = IconName.LOGO)
        Spacer(modifier = Modifier.height(height = Themes.size.spaceSize24))
        Column(verticalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize24)) {
            TextField(
                label = stringResource(id = R.string.email),
                value = email,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                onValueChange = {
                    email = it
                }
            )
            TextPassword(
                label = stringResource(id = R.string.password),
                value = password,
                imeAction = ImeAction.Go,
                onValueChange = {
                    password = it
                }
            )
            LoadingButton(
                label = stringResource(id = R.string.sign_in),
                onClick = {

                }
            )
            Spacer(modifier = Modifier.height(height = Themes.size.spaceSize64))
        }
    }
}
