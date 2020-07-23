package dev.shtanko.hawk.ui.profile.mapper

import dev.shtanko.core.Mapper
import dev.shtanko.core.network.responses.BaseResponse
import dev.shtanko.hawk.network.model.UserResponse
import dev.shtanko.hawk.ui.profile.model.User

class UserMapper : Mapper<BaseResponse<UserResponse>, User> {
    override suspend fun map(from: BaseResponse<UserResponse>): User {
        val userResponse = from.data.results.first()
        return User(
            userResponse.country,
            userResponse.displayName,
            userResponse.explicitContent,
            userResponse.uri
        )
    }
}
