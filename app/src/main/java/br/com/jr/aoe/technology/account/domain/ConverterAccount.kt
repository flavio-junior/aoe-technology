package br.com.jr.aoe.technology.account.domain

import br.com.jr.aoe.technology.account.data.dto.LoginResponseDTO
import br.com.jr.aoe.technology.account.data.vo.LoginResponseVO

class ConverterAccount {

    fun convertLoginResponseDTOToVO(
        loginResponseDTO: LoginResponseDTO
    ): LoginResponseVO {
        return LoginResponseVO(
            id = loginResponseDTO.id,
            customerName = loginResponseDTO.customerName,
            accountNumber = loginResponseDTO.accountNumber,
            branchNumber = loginResponseDTO.branchNumber,
            checkingAccountBalance = loginResponseDTO.checkingAccountBalance
        )
    }
}
