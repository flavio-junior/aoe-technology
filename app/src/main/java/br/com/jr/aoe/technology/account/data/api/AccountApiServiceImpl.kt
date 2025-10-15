package br.com.jr.aoe.technology.account.data.api

import retrofit2.http.GET

class AccountApiServiceImpl : AccountApiService {

    @GET(value = "https://60bd336db8ab3700175a03b3.mockapi.io/treinamento/Login")
    override fun signIn() {

    }
}
