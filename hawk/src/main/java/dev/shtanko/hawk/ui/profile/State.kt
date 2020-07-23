package dev.shtanko.hawk.ui.profile

data class ProfileViewState(val fetchStatus: FetchStatus, val newsList: List<Int>)

sealed class ProfileViewEffect {
    data class ShowSnackbar(val message: String) : ProfileViewEffect()
    data class ShowToast(val message: String) : ProfileViewEffect()
}

sealed class ProfileViewEvent {
    data class NewsItemClicked(val newsItem: Int) : ProfileViewEvent()
    object FabClicked : ProfileViewEvent()
    object OnSwipeRefresh : ProfileViewEvent()
    object FetchNews : ProfileViewEvent()
}

sealed class FetchStatus {
    object Fetching : FetchStatus()
    object Fetched : FetchStatus()
    object NotFetched : FetchStatus()
}
