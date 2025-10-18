package br.com.jr.aoe.technology.feature.payment.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.jr.aoe.technology.feature.payment.ui.view.PaymentScreen
import br.com.jr.aoe.technology.navigation.AppDestinations
import br.com.jr.aoe.technology.navigation.finishApp

fun NavGraphBuilder.paymentNavigation(
    navController: NavHostController
) {
    composable<AppDestinations.Payment> {
        PaymentScreen(
            goToSignInScreen = {
                navController.navigate(route = it)
            },
            goToAlternativeRoutes = {
                navController.navigate(route = AppDestinations.ErrorScreen)
            },
            exitApp = {
                navController.finishApp()
            }
        )
    }
}
