package br.com.jr.aoe.technology.network.data.datasource.local

import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO

interface LocalStorageDataSource {
    suspend fun saveToken(loginResponseVO: LoginResponseVO)
    suspend fun getToken(): LoginResponseVO?
    suspend fun cleanToken()
}
