package br.com.jr.aoe.technology.feature.account.data.datasource

import br.com.jr.aoe.technology.feature.account.data.dto.LoginResponseDTO
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

interface AccountRemoteDataSource {
    fun signIn(): Flow<ObserveNetworkStateHandler<LoginResponseDTO>>
}
