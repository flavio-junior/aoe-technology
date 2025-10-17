package br.com.jr.aoe.technology.feature.payment.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.jr.aoe.technology.design.system.components.Header
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.feature.payment.R
import br.com.jr.aoe.technology.navigation.AppDestinations
import br.com.jr.aoe.technology.network.ui.viewmodel.LocalStorageViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PaymentScreen(
    goToSignInScreen: (AppDestinations) -> Unit = {},
    exitApp: () -> Unit = {}
) {
    val localStorageViewModel: LocalStorageViewModel = koinViewModel()
    Column(modifier = Modifier.padding(horizontal = Themes.size.spaceSize16)) {
        Header(
            label = stringResource(id = R.string.payments),
            onClick = {
                localStorageViewModel.cleanToken()
                goToSignInScreen(AppDestinations.SplashScreen)
            }
        )
        BackHandler(enabled = true, onBack = exitApp)
    }
}
