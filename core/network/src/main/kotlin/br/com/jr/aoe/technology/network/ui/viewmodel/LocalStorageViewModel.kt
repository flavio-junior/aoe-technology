package br.com.jr.aoe.technology.network.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO
import br.com.jr.aoe.technology.network.data.repository.LocalStorageRepository
import br.com.jr.aoe.technology.network.ui.view.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocalStorageViewModel(
    private val localStorageRepository: LocalStorageRepository
) : ViewModel(), LocalStorageImpl {

    private val _getTokenSaved = MutableStateFlow<UiState<LoginResponseVO?>>(value = UiState.Init)
    val getTokenSaved = _getTokenSaved.asStateFlow()

    private val _cleanToken = MutableStateFlow<UiState<Unit>>(value = UiState.Init)
    val cleanToken = _cleanToken.asStateFlow()

    init {
        getToken()
    }

    override fun saveToken(loginResponseVO: LoginResponseVO) {
        viewModelScope.launch {
            localStorageRepository.saveToken(loginResponseVO = loginResponseVO)
        }
    }

    override fun getToken() {
        viewModelScope.launch {
            _getTokenSaved.value = UiState.Loading
            val tokenSaved: LoginResponseVO? = localStorageRepository.getToken()
            _getTokenSaved.value = UiState.OnSuccess(response = tokenSaved)
        }
    }

    override fun cleanToken() {
        viewModelScope.launch {
            _cleanToken.value = UiState.Loading
            localStorageRepository.cleanToken()
            _cleanToken.value = UiState.OnSuccess(response = Unit)
        }
    }
}
