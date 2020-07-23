package dev.shtanko.hawk.network.interceptor

import dev.shtanko.hawk.network.api.ACCESS_TOKEN
import java.io.IOException
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()

        builder.header(
            "Authorization", ACCESS_TOKEN
        )

        val request = builder.build()
        return chain.proceed(request)
    }
}
