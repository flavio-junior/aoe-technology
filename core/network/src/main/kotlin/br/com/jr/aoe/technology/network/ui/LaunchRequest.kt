package br.com.jr.aoe.technology.network.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

fun <DTO, VO> ViewModel.launchRequestWithResponse(
    request: Flow<ObserveNetworkStateHandler<DTO>>,
    state: MutableStateFlow<UiState<VO>>,
    mapper: (DTO) -> VO
) {
    viewModelScope.launch {
        request.collect { response ->
            when (response) {
                is ObserveNetworkStateHandler.Loading ->
                    state.value = UiState.Loading

                is ObserveNetworkStateHandler.Error ->
                    state.value = UiState.Error(error = response.exception)

                is ObserveNetworkStateHandler.Success ->
                    response.result?.let {
                        state.value = UiState.OnSuccess(response = mapper(it))
                    }
            }
        }
    }
}

fun <R> ViewModel.launchRequestWithoutResponse(
    request: Flow<ObserveNetworkStateHandler<R>>,
    state: MutableStateFlow<UiState<Unit>>
) {
    viewModelScope.launch {
        request.collect { response ->
            when (response) {
                is ObserveNetworkStateHandler.Loading ->
                    state.value = UiState.Loading

                is ObserveNetworkStateHandler.Error ->
                    state.value = UiState.Error(error = response.exception)

                is ObserveNetworkStateHandler.Success ->
                    state.value = UiState.OnSuccess(response = Unit)
            }
        }
    }
}
