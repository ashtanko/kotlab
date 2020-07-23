package dev.shtanko.hawk.di

import com.spotify.android.appremote.api.ConnectionParams
import dev.shtanko.hawk.BuildConfig
import dev.shtanko.hawk.network.api.UserService
import dev.shtanko.hawk.repository.ProfileRepository
import dev.shtanko.hawk.ui.profile.ProfileViewModelFactory

val connectionParams: ConnectionParams =
    ConnectionParams.Builder(BuildConfig.SPOTIFY_CLIENT_ID)
        .setRedirectUri(BuildConfig.SPOTIFY_REDIRECT_URI)
        .showAuthView(true).build()

fun provideProfileViewModelFactory(): ProfileViewModelFactory {
    return ProfileViewModelFactory(ProfileRepository(UserService.create()))
}
