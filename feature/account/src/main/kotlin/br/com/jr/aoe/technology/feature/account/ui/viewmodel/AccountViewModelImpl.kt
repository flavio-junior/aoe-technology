package br.com.jr.aoe.technology.feature.account.ui.viewmodel

import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO

interface AccountViewModelImpl {
    fun signIn(email: String)
    fun saveToken(loginResponseVO: LoginResponseVO)
    fun resetScreen()
}
