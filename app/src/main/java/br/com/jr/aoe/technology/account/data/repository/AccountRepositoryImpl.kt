package br.com.jr.aoe.technology.account.data.repository

import br.com.jr.aoe.technology.account.data.datasource.AccountRemoteDataSource

class AccountRepositoryImpl(
    private val accountRemoteDataSource: AccountRemoteDataSource
) : AccountRepository {

    override fun signIn() {
        accountRemoteDataSource.signIn()
    }
}
