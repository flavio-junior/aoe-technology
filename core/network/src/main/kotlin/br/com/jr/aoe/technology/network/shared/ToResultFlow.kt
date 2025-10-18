package br.com.jr.aoe.technology.network.shared

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.io.EOFException

inline fun <reified T> toResultFlow(
    context: Context,
    crossinline call: suspend () -> Response<T>
): Flow<ObserveNetworkStateHandler<T>> {
    return flow {
        if (hasInternetConnection(context)) {
            emit(value = ObserveNetworkStateHandler.Loading(l = true))
            try {
                val c: Response<T> = call()
                if (c.isSuccessful && c.code() in StatusCode.NUMBER_200..StatusCode.NUMBER_299) {
                    emit(value = ObserveNetworkStateHandler.Success(s = c.body()))
                } else if (c.code() in StatusCode.NUMBER_400..StatusCode.NUMBER_499) {
                    emit(
                        value = ObserveNetworkStateHandler.Error(
                            e = DescriptionError(
                                type = ErrorType.CLIENT,
                                message = "Error"
                            )
                        )
                    )
                }
            } catch (e: EOFException) {
                emit(
                    value = ObserveNetworkStateHandler.Error(
                        e = DescriptionError(
                            type = ErrorType.INTERNAL,
                            message = e.message.orEmpty()
                        )
                    )
                )
            }
        } else {
            emit(
                value = ObserveNetworkStateHandler.Error(
                    e = DescriptionError(type = ErrorType.INTERNAL)
                )
            )
        }
    }.flowOn(context = Dispatchers.IO)
}
