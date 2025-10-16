package br.com.jr.aoe.technology.network.shared

enum class Exceptions {
    ERROR_401,
    ERROR_403,
    ERROR_404,
    ERROR_500,
    ERROR_501,
    ERROR_503,
    ERROR_504,
    TIMEOUT,
    WITHOUT_CONNECTION_NETWORK,
    UNDEFINED_ROUTE,
    OTHER
}

fun determineErrorRoute(
    code: Int? = null,
    goToAlternativeRoutes: (Exceptions) -> Unit = {},
    exceptions: Exceptions? = null
) {
    if (code != null) {
        when (code) {
            401 -> goToAlternativeRoutes(Exceptions.ERROR_401)
            403 -> goToAlternativeRoutes(Exceptions.ERROR_403)
            404 -> goToAlternativeRoutes(Exceptions.ERROR_404)
            500 -> goToAlternativeRoutes(Exceptions.ERROR_500)
            501 -> goToAlternativeRoutes(Exceptions.ERROR_501)
            503 -> goToAlternativeRoutes(Exceptions.ERROR_503)
            504 -> goToAlternativeRoutes(Exceptions.ERROR_504)
            else -> goToAlternativeRoutes(Exceptions.OTHER)
        }
    } else {
        when (exceptions) {
            Exceptions.ERROR_503 ->
                goToAlternativeRoutes(Exceptions.ERROR_503)

            Exceptions.TIMEOUT ->
                goToAlternativeRoutes(Exceptions.TIMEOUT)

            Exceptions.WITHOUT_CONNECTION_NETWORK ->
                goToAlternativeRoutes(Exceptions.WITHOUT_CONNECTION_NETWORK)

            else -> goToAlternativeRoutes(Exceptions.OTHER)
        }
    }
}
