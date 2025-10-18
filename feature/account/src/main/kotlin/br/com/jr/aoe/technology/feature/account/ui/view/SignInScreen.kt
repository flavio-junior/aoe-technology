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
import br.com.jr.aoe.technology.design.system.resources.GenericsNumbers
import br.com.jr.aoe.technology.design.system.resources.isNotBlankAndEmpty
import br.com.jr.aoe.technology.design.system.resources.validateEmail
import br.com.jr.aoe.technology.design.system.resources.validatePassword
import br.com.jr.aoe.technology.design.system.settings.Align
import br.com.jr.aoe.technology.design.system.settings.Settings
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.feature.account.R
import br.com.jr.aoe.technology.feature.account.ui.viewmodel.AccountViewModel
import br.com.jr.aoe.technology.navigation.AppDestinations
import br.com.jr.aoe.technology.network.shared.Observer
import br.com.jr.aoe.technology.network.shared.enabledObserver
import br.com.jr.aoe.technology.network.shared.invalidEmail
import br.com.jr.aoe.technology.network.shared.invalidPassword
import br.com.jr.aoe.technology.network.shared.notBlankOrEmpty
import br.com.jr.aoe.technology.network.shared.passwordErrorSize
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    goToAlternativeRoutes: () -> Unit = {},
    goToNextScreen: (AppDestinations) -> Unit = {}
) {
    val viewModel: AccountViewModel = koinViewModel()
    var email: String by remember { mutableStateOf(value = Settings.EMPTY_TEXT) }
    var password: String by remember { mutableStateOf(value = Settings.EMPTY_TEXT) }
    var observer: Observer by remember { mutableStateOf(value = Observer()) }
    val checkSignIn: (String, String) -> Unit =
        { emailArg: String, passwordArg: String ->
            verifyFieldsToSignInScreen(
                triple = Triple(
                    first = emailArg,
                    second = passwordArg,
                    third = viewModel
                ),
                onError = {
                    observer = it
                }
            )
        }
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
                iconName = IconName.MAIL,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                isError = observer.error,
                onValueChange = {
                    email = it
                }
            )
            TextPassword(
                label = stringResource(id = R.string.password),
                value = password,
                imeAction = ImeAction.Go,
                isError = observer.error,
                message = observer.message,
                onValueChange = {
                    password = it
                },
                onGo = {
                    checkSignIn(email, password)
                }
            )
            LoadingButton(
                label = stringResource(id = R.string.sign_in),
                isEnabled = observer.enabled,
                onClick = {
                    observer = enabledObserver
                    checkSignIn(email, password)
                }
            )
            Spacer(modifier = Modifier.height(height = Themes.size.spaceSize64))
        }
    }
    UiResponseSingInScreen(
        viewModel = viewModel,
        goToAlternativeRoutes = goToAlternativeRoutes,
        onError = {
            observer = it
        },
        onResult = {
            goToNextScreen(AppDestinations.Payment)
        }
    )
}

private fun verifyFieldsToSignInScreen(
    triple: Triple<String, String, AccountViewModel>,
    onError: (Observer) -> Unit = {}
) {
    if (triple.first.isNotBlankAndEmpty() && triple.second.isNotBlankAndEmpty()) {
        if (validateEmail(email = triple.first)) {
            if (validatePassword(password = triple.second)) {
                onError(enabledObserver)
                triple.third.signIn(email = triple.first)
            } else if (triple.second.length < GenericsNumbers.NUMBER_SIX) {
                onError(passwordErrorSize)
            } else {
                onError(invalidPassword)
            }
        } else {
            onError(invalidEmail)
        }
    } else {
        onError(notBlankOrEmpty)
    }
}
