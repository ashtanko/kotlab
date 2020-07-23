package dev.shtanko.hawk.ui.profile

import android.os.Bundle
import androidx.activity.viewModels
import dev.shtanko.hawk.R
import dev.shtanko.hawk.di.provideProfileViewModelFactory
import mvi.MviActivity

class ProfileActivity :
    MviActivity<ProfileViewState, ProfileViewEffect, ProfileViewEvent, ProfileViewModel>() {

    private val profileViewModel: ProfileViewModel by viewModels {
        provideProfileViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        viewModel.process(ProfileViewEvent.FetchProfile)
    }

    override val viewModel: ProfileViewModel
        get() = profileViewModel

    override fun renderViewState(viewState: ProfileViewState) {
        when (viewState.fetchStatus) {
            is FetchStatus.Fetched -> {
                // todo
            }
        }
    }

    override fun renderViewEffect(viewEffect: ProfileViewEffect) {
        when (viewEffect) {
            is ProfileViewEffect.ShowSnackbar -> {
                // todo
            }
        }
    }
}
