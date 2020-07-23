package dev.shtanko.hawk.network.api

import com.google.gson.GsonBuilder
import dev.shtanko.hawk.network.interceptor.AuthenticationInterceptor
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.spotify.com"
private const val KB = 1024L
private const val MB = KB * 1024L
private const val CACHE_SIZE: Long = 50L * MB // 50 MiB
private const val GSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
private const val CONNECTION_TIMEOUT = 120L
private const val READ_TIMEOUT = 60L
private const val WRITE_TIMEOUT = 60L

fun getRetrofit(): Retrofit {
    val logger =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    val gson = GsonBuilder().setPrettyPrinting()
        .setDateFormat(GSON_DATE_FORMAT)
        .setLenient()
        .create()

    val client = OkHttpClient().newBuilder()
        .addInterceptor(logger)
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .addNetworkInterceptor(AuthenticationInterceptor())
        .retryOnConnectionFailure(true)
        .build()

    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}
