package br.com.jr.aoe.technology.feature.payment.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.jr.aoe.technology.feature.payment.data.storage.Payment

@Dao
interface PaymentLocalDataSource {
    @Insert
    suspend fun saveAllPayments(vararg payments: Payment)

    @Query(value = "SELECT * FROM payment")
    suspend fun getAllPayments(): List<Payment>

    @Delete
    suspend fun deletePayment(payment: Payment)
}
