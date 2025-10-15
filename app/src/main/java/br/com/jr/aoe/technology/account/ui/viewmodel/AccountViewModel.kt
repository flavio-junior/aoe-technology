package br.com.jr.aoe.technology.account.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.jr.aoe.technology.account.data.repository.AccountRepository
import br.com.jr.aoe.technology.account.data.vo.LoginResponseVO
import br.com.jr.aoe.technology.account.domain.ConverterAccount
import br.com.jr.aoe.technology.network.ui.UiState
import br.com.jr.aoe.technology.network.ui.launchRequestWithResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AccountViewModel(
    private val accountRepository: AccountRepository,
    private val converter: ConverterAccount
) : ViewModel(), AccountViewModelImpl {

    private val _loginResponseVO = MutableStateFlow<UiState<LoginResponseVO>>(value = UiState.Init)
    val loginResponseVO = _loginResponseVO.asStateFlow()

    override fun signIn() {
        launchRequestWithResponse(
            request = accountRepository.signIn(),
            state = _loginResponseVO,
            mapper = {
                converter.convertLoginResponseDTOToVO(loginResponseDTO = it)
            }
        )
    }
}
