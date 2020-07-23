package dev.shtanko.hawk.network.api

import dev.shtanko.hawk.network.model.BaseResponse
import dev.shtanko.hawk.network.model.User
import retrofit2.http.GET

interface UserService {

    @GET("/v1/me")
    fun getCurrentUser(): BaseResponse<User>
}
