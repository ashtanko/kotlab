package dev.shtanko.hawk.ui.profile

import androidx.lifecycle.viewModelScope
import dev.shtanko.hawk.repository.ProfileRepository
import dev.shtanko.hawk.ui.profile.mapper.UserMapper
import java.io.IOException
import kotlinx.coroutines.launch
import mvi.MviViewModel

class ProfileViewModel(
    private val profileRepository: ProfileRepository,
    private val mapper: UserMapper
) : MviViewModel<ProfileViewState, ProfileViewEffect, ProfileViewEvent>() {

    init {
        viewState = ProfileViewState(fetchStatus = FetchStatus.NotFetched)
    }

    override fun process(viewEvent: ProfileViewEvent) {
        super.process(viewEvent)

        when (viewEvent) {
            is ProfileViewEvent.FetchProfile -> {
                fetchCurrentProfile()
            }
        }
    }

    private fun fetchCurrentProfile() {
        viewState = viewState.copy(fetchStatus = FetchStatus.Fetching)
        viewModelScope.launch {
            try {
                val result = profileRepository.getCurrentUser()
                viewState =
                    viewState.copy(fetchStatus = FetchStatus.Fetched, data = mapper.map(result))
            } catch (e: IOException) { // todo
                viewState = viewState.copy(fetchStatus = FetchStatus.Fetched)
                viewEffect =
                    ProfileViewEffect.ShowToast(message = e.localizedMessage ?: "error") // todo
            }
        }
    }
}
