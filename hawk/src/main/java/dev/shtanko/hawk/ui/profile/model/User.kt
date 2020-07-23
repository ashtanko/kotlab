package dev.shtanko.hawk.ui.profile.model

import dev.shtanko.hawk.network.model.ExplicitContent

data class User(
    val country: String,
    val displayName: String,
    val explicitContent: ExplicitContent,
    val uri: String
)
