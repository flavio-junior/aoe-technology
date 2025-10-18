package br.com.jr.aoe.technology.network.shared

data class DescriptionError(
    val code: Int? = null,
    val type: ErrorType = ErrorType.CLIENT,
    val message: String? = null
)
