package br.com.jr.aoe.technology.account.data.datasource

import android.content.Context
import br.com.jr.aoe.technology.account.data.api.AccountApiService
import br.com.jr.aoe.technology.account.data.dto.LoginResponseDTO
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import br.com.jr.aoe.technology.network.shared.toResultFlow
import kotlinx.coroutines.flow.Flow

class AccountRemoteDataSourceImpl(
    private val context: Context,
    private val accountApiService: AccountApiService
) : AccountRemoteDataSource {

    override fun signIn(): Flow<ObserveNetworkStateHandler<LoginResponseDTO>> {
        return toResultFlow(
            context = context,
            call = {
                accountApiService.signIn()
            }
        )
    }
}
