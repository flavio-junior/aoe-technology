package br.com.jr.aoe.technology.account.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jr.aoe.technology.account.data.repository.AccountRepository
import br.com.jr.aoe.technology.account.data.vo.LoginResponseVO
import br.com.jr.aoe.technology.account.domain.ConverterAccount
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import br.com.jr.aoe.technology.network.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AccountViewModel(
    private val accountRepository: AccountRepository,
    private val converter: ConverterAccount
) : ViewModel(), AccountViewModelImpl {

    private val _loginResponseVO = MutableStateFlow<UiState<LoginResponseVO>>(value = UiState.Init)
    val loginResponseVO = _loginResponseVO.asStateFlow()

    override fun signIn() {
        viewModelScope.launch {
            accountRepository.signIn().collect { response ->
                when (response) {
                    is ObserveNetworkStateHandler.Loading ->
                        _loginResponseVO.value = UiState.Loading

                    is ObserveNetworkStateHandler.Error ->
                        _loginResponseVO.value = UiState.Error(error = response.exception)

                    is ObserveNetworkStateHandler.Success -> {
                        val loginResponseVO =
                            converter.convertLoginResponseDTOToVO(loginResponseDTO = response.result)

                        _loginResponseVO.value = UiState.OnSuccess(response = loginResponseVO)
                    }
                }
            }
        }
    }
}
