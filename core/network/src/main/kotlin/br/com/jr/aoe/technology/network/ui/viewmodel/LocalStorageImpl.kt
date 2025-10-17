package br.com.jr.aoe.technology.network.ui.viewmodel

import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO

interface LocalStorageImpl {
    fun saveToken(loginResponseVO: LoginResponseVO)
    fun getToken()
    fun cleanToken()
}
