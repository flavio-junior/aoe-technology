package br.com.jr.aoe.technology.feature.payment.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Payment(
    @PrimaryKey val id: Long? = 0,
    @ColumnInfo(name = "payment_date") val paymentDate: String? = "",
    @ColumnInfo(name = "electricity_bill") val electricityBill: String? = ""
)
