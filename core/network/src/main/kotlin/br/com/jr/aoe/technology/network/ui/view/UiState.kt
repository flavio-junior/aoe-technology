package br.com.jr.aoe.technology.network.ui.view

import br.com.jr.aoe.technology.network.shared.DescriptionError

sealed class UiState<out T> {
    data object Init : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
    data class OnSuccess<out T>(val response: T) : UiState<T>()
    data class Error(val error: DescriptionError) : UiState<Nothing>()
}
