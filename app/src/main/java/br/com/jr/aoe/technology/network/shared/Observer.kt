package br.com.jr.aoe.technology.network.shared

data class Observer(
    var enabled: Boolean = false,
    var error: Boolean = false,
    var message: String? = null
)
