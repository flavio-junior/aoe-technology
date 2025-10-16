package br.com.jr.aoe.technology.feature.ui.shared.domain

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.jr.aoe.technology.navigation.AppDestinations

fun NavGraphBuilder.uiSharedNavigation(
    navController: NavHostController
) {
    composable<AppDestinations.Payment> {

    }
}
