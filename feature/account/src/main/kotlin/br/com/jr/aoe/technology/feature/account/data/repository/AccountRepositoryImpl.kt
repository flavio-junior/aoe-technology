package br.com.jr.aoe.technology.feature.account.data.repository

import br.com.jr.aoe.technology.feature.account.data.datasource.AccountRemoteDataSource
import br.com.jr.aoe.technology.feature.account.data.dto.LoginResponseDTO
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

class AccountRepositoryImpl(
    private val accountRemoteDataSource: AccountRemoteDataSource
) : AccountRepository {

    override fun signIn(): Flow<ObserveNetworkStateHandler<LoginResponseDTO>> {
        return accountRemoteDataSource.signIn()
    }
}
