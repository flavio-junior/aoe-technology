package br.com.jr.aoe.technology.feature.account.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.jr.aoe.technology.design.system.resources.validateEmail
import br.com.jr.aoe.technology.feature.account.data.repository.AccountRepository
import br.com.jr.aoe.technology.feature.account.data.vo.LoginResponseVO
import br.com.jr.aoe.technology.feature.account.domain.ConverterAccount
import br.com.jr.aoe.technology.network.shared.DescriptionError
import br.com.jr.aoe.technology.network.shared.Warnings
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

    override fun signIn(email: String) {
        if (validateEmail(email = email)) {
            launchRequestWithResponse(
                request = accountRepository.signIn(),
                state = _loginResponseVO,
                mapper = {
                    converter.convertLoginResponseDTOToVO(loginResponseDTO = it.first())
                }
            )
        } else {
            _loginResponseVO.value =
                UiState.Error(error = DescriptionError(message = Warnings.INVALID_EMAIL))
        }
    }

    override fun resetScreen() {
        _loginResponseVO.value = UiState.Init
    }
}
