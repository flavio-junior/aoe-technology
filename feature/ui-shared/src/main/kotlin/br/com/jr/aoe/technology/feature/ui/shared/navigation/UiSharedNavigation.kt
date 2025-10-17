package br.com.jr.aoe.technology.feature.ui.shared.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.jr.aoe.technology.feature.ui.shared.ui.SplashScreen
import br.com.jr.aoe.technology.navigation.AppDestinations

fun NavGraphBuilder.uiSharedNavigation(
    navController: NavHostController
) {
    composable<AppDestinations.SplashScreen> {
        SplashScreen(
            goToSignInScreen = {
                navController.navigate(route = it)
            },
            goToPaymentScreen = {
                navController.navigate(route = it)
            }
        )
    }
}
