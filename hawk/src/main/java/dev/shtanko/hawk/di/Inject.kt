package dev.shtanko.hawk.di

import com.spotify.android.appremote.api.ConnectionParams
import dev.shtanko.hawk.BuildConfig

val connectionParams: ConnectionParams =
    ConnectionParams.Builder(BuildConfig.SPOTIFY_CLIENT_ID)
        .setRedirectUri(BuildConfig.SPOTIFY_REDIRECT_URI)
        .showAuthView(true).build()
