package br.com.jr.aoe.technology.network.data.repository

import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO
import br.com.jr.aoe.technology.network.data.datasource.local.LocalStorageDataSource

class LocalStorageRepositoryImpl(
    private val localStorageDataSource: LocalStorageDataSource
): LocalStorageRepository {

    override suspend fun saveToken(loginResponseVO: LoginResponseVO) {
        localStorageDataSource.saveToken(loginResponseVO = loginResponseVO)
    }

    override suspend fun getToken(): LoginResponseVO? {
        return localStorageDataSource.getToken()
    }

    override suspend fun cleanToken() {
        localStorageDataSource.cleanToken()
    }
}
