package br.com.jr.aoe.technology.feature.account.data.repository

import br.com.jr.aoe.technology.feature.account.data.dto.LoginResponseDTO
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun signIn(): Flow<ObserveNetworkStateHandler<LoginResponseDTO>>
}
