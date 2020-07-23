package dev.shtanko.hawk.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.shtanko.hawk.repository.ProfileRepository
import dev.shtanko.hawk.ui.profile.mapper.UserMapper

class ProfileViewModelFactory(
    private val repository: ProfileRepository,
    private val mapper: UserMapper
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository, mapper) as T
    }
}
