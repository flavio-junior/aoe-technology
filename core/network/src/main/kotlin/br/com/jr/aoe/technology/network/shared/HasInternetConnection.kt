package br.com.jr.aoe.technology.network.shared

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun hasInternetConnection(context: Context?) = try {
    val connectivityManager: ConnectivityManager =
        context?.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager
    connectivityManager.activeNetwork?.let { activeNetwork ->
        connectivityManager.getNetworkCapabilities(activeNetwork)?.let { networkCapabilities ->
            when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } ?: false
    } ?: false
} catch (_: Exception) {
    false
}
