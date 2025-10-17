package br.com.jr.aoe.technology.cryptography

import android.os.Build
import androidx.annotation.RequiresApi
import br.com.jr.aoe.technology.cryptography.ManagerCryptography.cipher
import br.com.jr.aoe.technology.cryptography.ManagerCryptography.getKey
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

@RequiresApi(Build.VERSION_CODES.O)
fun encryptMessage(
    message: String?
): Pair<ByteArray, ByteArray?> {
    cipher.init(Cipher.ENCRYPT_MODE, getKey())
    val iv: ByteArray = cipher.iv
    val encrypted: ByteArray = cipher.doFinal(message?.toByteArray())
    return Pair(first = Base64.getEncoder().encode(iv + encrypted), second = null)
}

@RequiresApi(Build.VERSION_CODES.O)
fun decryptMessage(
    cryptography: ByteArray? = null
): String? {
    if (cryptography == null || cryptography.size <= cipher.blockSize) {
        return null
    }
    val encryptedBytesDecoded = Base64.getDecoder().decode(cryptography)
    val iv: ByteArray? = encryptedBytesDecoded.copyOfRange(0, cipher.blockSize)
    val data: ByteArray? =
        encryptedBytesDecoded.copyOfRange(cipher.blockSize, encryptedBytesDecoded.size)
    cipher.init(Cipher.DECRYPT_MODE, getKey(), IvParameterSpec(iv))
    val decryptedBytes = cipher.doFinal(data)
    return String(decryptedBytes, Charsets.UTF_8)
}
