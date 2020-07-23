package dev.shtanko.hawk.ui.profile

import dev.shtanko.hawk.repository.ProfileRepository
import mvi.MviViewModel

class ProfileViewModel(private val profileRepository: ProfileRepository) :
    MviViewModel<ProfileViewState, ProfileViewEffect, ProfileViewEvent>()
