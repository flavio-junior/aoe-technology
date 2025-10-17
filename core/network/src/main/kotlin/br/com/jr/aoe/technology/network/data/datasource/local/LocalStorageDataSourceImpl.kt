package br.com.jr.aoe.technology.network.data.datasource.local

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.byteArrayPreferencesKey
import androidx.datastore.preferences.core.edit
import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO
import br.com.jr.aoe.technology.cryptography.decryptMessage
import br.com.jr.aoe.technology.cryptography.encryptMessage
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class LocalStorageDataSourceImpl(
    private val dataStore: DataStore<Preferences>
) : LocalStorageDataSource {

    @RequiresApi(value = Build.VERSION_CODES.O)
    override suspend fun saveToken(loginResponseVO: LoginResponseVO) {
        dataStore.edit { settings ->
            settings[PREFERENCES_ID] =
                encryptMessage(message = loginResponseVO.id).first
            settings[PREFERENCES_CUSTOMER_NAME] =
                encryptMessage(message = loginResponseVO.customerName).first
            settings[PREFERENCES_ACCOUNT_NUMBER] =
                encryptMessage(message = loginResponseVO.accountNumber).first
            settings[PREFERENCES_BRANCH_NUMBER] =
                encryptMessage(message = loginResponseVO.branchNumber).first
            settings[PREFERENCES_CHECKING_ACCOUNT_BALANCE] =
                encryptMessage(message = loginResponseVO.checkingAccountBalance).first
        }
    }

    @RequiresApi(value = Build.VERSION_CODES.O)
    override suspend fun getToken(): LoginResponseVO? {
        return dataStore.data.map { currentPreferences ->
            LoginResponseVO(
                id = decryptMessage(cryptography = currentPreferences[PREFERENCES_ID]),
                customerName = decryptMessage(cryptography = currentPreferences[PREFERENCES_CUSTOMER_NAME]),
                accountNumber = decryptMessage(cryptography = currentPreferences[PREFERENCES_ACCOUNT_NUMBER]),
                branchNumber = decryptMessage(cryptography = currentPreferences[PREFERENCES_BRANCH_NUMBER]),
                checkingAccountBalance = decryptMessage(cryptography = currentPreferences[PREFERENCES_CHECKING_ACCOUNT_BALANCE]),
            )
        }.firstOrNull()
    }

    override suspend fun cleanToken() {
        dataStore.edit { settings ->
            settings.remove(key = PREFERENCES_ID)
            settings.remove(key = PREFERENCES_CUSTOMER_NAME)
            settings.remove(key = PREFERENCES_ACCOUNT_NUMBER)
            settings.remove(key = PREFERENCES_BRANCH_NUMBER)
            settings.remove(key = PREFERENCES_CHECKING_ACCOUNT_BALANCE)
        }
    }

    companion object {
        private val PREFERENCES_ID = byteArrayPreferencesKey(name = "id")
        private val PREFERENCES_CUSTOMER_NAME = byteArrayPreferencesKey(name = "customer_name")
        private val PREFERENCES_ACCOUNT_NUMBER = byteArrayPreferencesKey(name = "account_number")
        private val PREFERENCES_BRANCH_NUMBER = byteArrayPreferencesKey(name = "branch_number")
        private val PREFERENCES_CHECKING_ACCOUNT_BALANCE =
            byteArrayPreferencesKey(name = "checking_account_balance")
    }
}


