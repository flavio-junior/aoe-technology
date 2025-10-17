package br.com.jr.aoe.technology.network.retrofit

import br.com.jr.aoe.technology.network.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.URL_API)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun provideOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor
) = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .connectTimeout(timeout = 30, unit = TimeUnit.SECONDS)
    .readTimeout(timeout = 30, unit = TimeUnit.SECONDS)
    .build()

fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()

fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(level = HttpLoggingInterceptor.Level.BODY)
