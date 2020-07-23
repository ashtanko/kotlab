package dev.shtanko.hawk.ui.profile

import dev.shtanko.hawk.ui.profile.model.User

data class ProfileViewState(val fetchStatus: FetchStatus, val data: User? = null)

sealed class ProfileViewEffect {
    data class ShowSnackbar(val message: String) : ProfileViewEffect()
    data class ShowToast(val message: String) : ProfileViewEffect()
}

sealed class ProfileViewEvent {
    data class NewsItemClicked(val newsItem: Int) : ProfileViewEvent()
    object FabClicked : ProfileViewEvent()
    object OnSwipeRefresh : ProfileViewEvent()
    object FetchProfile : ProfileViewEvent()
}

sealed class FetchStatus {
    object Fetching : FetchStatus()
    object Fetched : FetchStatus()
    object NotFetched : FetchStatus()
}
