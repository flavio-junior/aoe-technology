package br.com.jr.aoe.technology.feature.ui.shared.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import br.com.jr.aoe.technology.design.system.components.CommonImage
import br.com.jr.aoe.technology.design.system.factory.IconName
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.navigation.AppDestinations
import br.com.jr.aoe.technology.network.di.networkModule
import br.com.jr.aoe.technology.network.ui.view.UiResponseGetTokenSaved
import br.com.jr.aoe.technology.network.ui.viewmodel.LocalStorageViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication

@Composable
fun SplashScreen(
    goToSignInScreen: (AppDestinations) -> Unit = {},
    goToPaymentScreen: (AppDestinations) -> Unit = {}
) {
    val localStorageViewModel: LocalStorageViewModel = koinViewModel()
    Column(
        modifier = Modifier
            .background(color = Themes.colors.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonImage(
            iconName = IconName.LOGO,
            modifier = Modifier.padding(horizontal = Themes.size.spaceSize16)
        )
        LaunchedEffect(key1 = Unit) {
            localStorageViewModel.getToken()
        }
    }
    UiResponseGetTokenSaved(
        goToSignInScreen = {
            goToSignInScreen(AppDestinations.Account)
        },
        goToPaymentScreen = {
            goToPaymentScreen(AppDestinations.Payment)
        }
    )
}

@Composable
@Preview(apiLevel = 35, showBackground = true)
private fun SplashScreenPreview() {
    val context = LocalContext.current
    KoinApplication(application = {
        androidContext(androidContext = context)
        modules(modules = listOf(networkModule))
    }) {
        SplashScreen()
    }
}
