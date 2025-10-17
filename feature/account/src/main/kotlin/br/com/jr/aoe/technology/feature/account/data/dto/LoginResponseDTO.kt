package br.com.jr.aoe.technology.feature.account.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDTO(
    val id: String? = "",
    val customerName: String? = "",
    val accountNumber: String? = "",
    val branchNumber: String? = "",
    val checkingAccountBalance: String? = ""
)
