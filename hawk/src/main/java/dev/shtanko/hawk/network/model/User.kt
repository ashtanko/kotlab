package dev.shtanko.hawk.network.model

import com.google.gson.annotations.SerializedName

data class ExplicitContent(
    @SerializedName("filter_enabled")
    val filterEnabled: Boolean,
    @SerializedName("filter_locked")
    val filterLocked: Boolean
)

data class User(
    val country: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("explicit_content")
    val explicitContent: ExplicitContent,
    val uri: String
)
