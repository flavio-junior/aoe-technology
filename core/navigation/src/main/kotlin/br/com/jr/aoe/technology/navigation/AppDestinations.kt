package br.com.jr.aoe.technology.navigation

import kotlinx.serialization.Serializable

sealed interface AppDestinations {

    @Serializable
    data object Account : AppDestinations

    @Serializable

    data object Payment : AppDestinations
}
