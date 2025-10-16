package br.com.jr.aoe.technology.feature.payment.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.jr.aoe.technology.feature.payment.ui.view.PaymentScreen
import br.com.jr.aoe.technology.navigation.AppDestinations

fun NavGraphBuilder.paymentNavigation(
    navController: NavHostController
) {
    composable<AppDestinations.Payment> {
        PaymentScreen()
    }
}
