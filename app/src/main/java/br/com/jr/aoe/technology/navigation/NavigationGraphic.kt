package br.com.jr.aoe.technology.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.jr.aoe.technology.feature.account.navigation.accountNavigation
import br.com.jr.aoe.technology.feature.payment.navigation.paymentNavigation
import br.com.jr.aoe.technology.feature.ui.shared.navigation.uiSharedNavigation

@Composable
fun NavigationGraphic(
    navController: NavHostController = rememberNavController(),
    startDestination: AppDestinations = AppDestinations.SplashScreen
) {
    NavHost(navController = navController, startDestination = startDestination) {
        accountNavigation(navController = navController)
        paymentNavigation(navController = navController)
        uiSharedNavigation(navController = navController)
    }
}
