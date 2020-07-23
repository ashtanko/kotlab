package dev.shtanko.hawk.network.api

import dev.shtanko.core.network.responses.BaseResponse
import dev.shtanko.hawk.network.model.UserResponse
import retrofit2.http.GET

interface UserService {

    @GET("/v1/me")
    suspend fun getCurrentUser(): BaseResponse<UserResponse>

    companion object {
        fun create(): UserService = getRetrofit().create(UserService::class.java)
    }
}
