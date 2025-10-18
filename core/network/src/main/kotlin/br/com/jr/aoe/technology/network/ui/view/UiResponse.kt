package br.com.jr.aoe.technology.network.ui.view

import androidx.compose.runtime.Composable
import br.com.jr.aoe.technology.network.shared.DescriptionError
import br.com.jr.aoe.technology.network.shared.ErrorType
import br.com.jr.aoe.technology.network.shared.Observer

@Composable
fun <T> UiResponse(
    state: UiState<T>,
    onLoading: @Composable () -> Unit = {},
    onError: @Composable (Observer) -> Unit = {},
    goToAlternativeRoutes: () -> Unit = {},
    onSuccess: @Composable (T) -> Unit = {}
) {
    when (state) {
        is UiState.Init -> Unit

        is UiState.Loading -> onLoading()

        is UiState.Error -> {
            val error: DescriptionError = state.error
            when (error.type) {
                ErrorType.CLIENT -> {
                    onError(Observer(enabled = false, error = true, message = error.message))
                }

                ErrorType.INTERNAL, ErrorType.EXTERNAL, ErrorType.SERVER -> {
                    goToAlternativeRoutes()
                }
            }
        }

        is UiState.OnSuccess -> {
            onError(Observer(enabled = false, error = false, message = ""))
            onSuccess(state.response)
        }
    }
}
