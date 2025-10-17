package br.com.jr.aoe.technology.feature.account.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.jr.aoe.technology.feature.account.ui.view.SignInScreen
import br.com.jr.aoe.technology.navigation.AppDestinations

fun NavGraphBuilder.accountNavigation(
    navController: NavHostController
) {
    composable<AppDestinations.Account> {
        SignInScreen(
            goToNextScreen = {
                navController.navigate(route = it)
            }
        )
    }
}
