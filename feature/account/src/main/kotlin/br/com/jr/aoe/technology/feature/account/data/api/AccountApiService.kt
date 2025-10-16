package br.com.jr.aoe.technology.feature.account.data.api

import br.com.jr.aoe.technology.feature.account.data.dto.LoginResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface AccountApiService {
    @GET(value = "treinamento/Login")
    suspend fun signIn(): Response<LoginResponseDTO>
}
