package br.com.jr.aoe.technology.network.data.repository

import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO

interface LocalStorageRepository {
    suspend fun saveToken(loginResponseVO: LoginResponseVO)
    suspend fun getToken(): LoginResponseVO?
    suspend fun cleanToken()
}
