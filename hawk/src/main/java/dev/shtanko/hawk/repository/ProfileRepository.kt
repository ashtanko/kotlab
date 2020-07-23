package dev.shtanko.hawk.repository

import dev.shtanko.core.network.responses.BaseResponse
import dev.shtanko.hawk.network.api.UserService
import dev.shtanko.hawk.network.model.UserResponse

class ProfileRepository(
    private val service: UserService
) : UserService by service {

    override suspend fun getCurrentUser(): BaseResponse<UserResponse> {
        return service.getCurrentUser()
    }
}
