package br.com.jr.aoe.technology.account.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDTO(
    val id: Long? = 0,
    val customerName: String? = "",
    val accountNumber: String? = "",
    val branchNumber: Long? = 0,
    val checkingAccountBalance: Int? = 0,
)
