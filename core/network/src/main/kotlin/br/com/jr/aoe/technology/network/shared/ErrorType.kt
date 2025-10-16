package br.com.jr.aoe.technology.network.shared

import kotlinx.coroutines.flow.FlowCollector

enum class ErrorType {
    CLIENT,
    SERVER,
    INTERNAL,
    EXTERNAL
}

suspend inline fun <reified T> clientError(
    collector: FlowCollector<ObserveNetworkStateHandler<T>>,
    code: Int? = null,
    message: String
) = collector.emit(
    value = ObserveNetworkStateHandler.Error(
        e = DescriptionError(
            code = code,
            type = ErrorType.CLIENT,
            message = message
        )
    )
)

suspend inline fun <reified T> serverError(
    collector: FlowCollector<ObserveNetworkStateHandler<T>>,
    code: Int,
    message: String
) = collector.emit(
    value = ObserveNetworkStateHandler.Error(
        e = DescriptionError(
            code = code,
            type = ErrorType.SERVER,
            message = message
        )
    )
)

suspend inline fun <reified T> internalError(
    collector: FlowCollector<ObserveNetworkStateHandler<T>>,
    message: String? = null
) = collector.emit(
    value = ObserveNetworkStateHandler.Error(
        e = DescriptionError(
            type = ErrorType.INTERNAL,
            message = message
        )
    )
)

suspend inline fun <reified T> externalError(
    collector: FlowCollector<ObserveNetworkStateHandler<T>>,
    message: String? = null
) = collector.emit(
    value = ObserveNetworkStateHandler.Error(
        e = DescriptionError(
            type = ErrorType.EXTERNAL,
            message = message
        )
    )
)

suspend inline fun <reified T> withoutConnectionNetworkError(
    collector: FlowCollector<ObserveNetworkStateHandler<T>>
) = collector.emit(
    value = ObserveNetworkStateHandler.Error(
        e = DescriptionError(
            type = ErrorType.EXTERNAL,
            exceptions = Exceptions.WITHOUT_CONNECTION_NETWORK
        )
    )
)

suspend inline fun <reified T> serviceUnavailableError(
    collector: FlowCollector<ObserveNetworkStateHandler<T>>
) = collector.emit(
    value = ObserveNetworkStateHandler.Error(
        e = DescriptionError(
            type = ErrorType.EXTERNAL,
            exceptions = Exceptions.ERROR_503
        )
    )
)

suspend inline fun <reified T> timeoutError(
    collector: FlowCollector<ObserveNetworkStateHandler<T>>
) = collector.emit(
    value = ObserveNetworkStateHandler.Error(
        e = DescriptionError(
            type = ErrorType.EXTERNAL,
            exceptions = Exceptions.TIMEOUT
        )
    )
)
