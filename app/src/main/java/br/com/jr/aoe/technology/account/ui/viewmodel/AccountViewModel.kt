package br.com.jr.aoe.technology.account.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jr.aoe.technology.account.data.repository.AccountRepository
import br.com.jr.aoe.technology.account.domain.ConverterAccount
import kotlinx.coroutines.launch

class AccountViewModel(
    private val accountRepository: AccountRepository,
    private val converter: ConverterAccount
) : ViewModel(), AccountViewModelImpl {

    override fun signIn() {
        viewModelScope.launch {
            accountRepository.signIn()
        }
    }
}
