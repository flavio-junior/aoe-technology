package br.com.jr.aoe.technology.account.data.datasource

import br.com.jr.aoe.technology.account.data.api.AccountApiService

class AccountRemoteDataSourceImpl(
    private val accountApiService: AccountApiService
) : AccountRemoteDataSource {

    override fun signIn() {
        accountApiService.signIn()
    }
}
