package br.com.jr.aoe.technology.feature.account.domain

import br.com.jr.aoe.technology.feature.account.data.dto.LoginResponseDTO
import br.com.jr.aoe.technology.feature.account.data.vo.LoginResponseVO

class ConverterAccount {

    fun convertLoginResponseDTOToVO(
        loginResponseDTO: LoginResponseDTO? = null
    ): LoginResponseVO {
        return LoginResponseVO(
            id = loginResponseDTO?.id,
            customerName = loginResponseDTO?.customerName,
            accountNumber = loginResponseDTO?.accountNumber,
            branchNumber = loginResponseDTO?.branchNumber,
            checkingAccountBalance = loginResponseDTO?.checkingAccountBalance
        )
    }
}
