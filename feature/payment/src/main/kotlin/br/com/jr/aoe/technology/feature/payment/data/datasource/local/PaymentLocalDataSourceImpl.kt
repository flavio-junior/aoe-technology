package br.com.jr.aoe.technology.feature.payment.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.jr.aoe.technology.feature.payment.data.storage.Payment

@Database(entities = [Payment::class], version = 1)
abstract class PaymentLocalDataSourceImpl : RoomDatabase() {
    abstract fun paymentDao(): PaymentLocalDataSource
}
