package br.com.jr.aoe.technology.account.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jr.aoe.technology.account.data.repository.AccountRepository
import kotlinx.coroutines.launch

class AccountViewModel(
    private val accountRepository: AccountRepository
) : ViewModel(), AccountViewModelImpl {

    override fun signIn() {
        viewModelScope.launch {
            accountRepository.signIn()
        }
    }
}
