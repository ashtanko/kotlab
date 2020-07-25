package mvi

data class ViewState(val fetchStatus: FetchStatus, val data: String? = null)

sealed class ViewEffect {
    data class ShowSnackbar(val message: String) : ViewEffect()
    data class ShowToast(val message: String) : ViewEffect()
}

sealed class ViewEvent {
    data class NewsItemClicked(val newsItem: Int) : ViewEvent()
    object FabClicked : ViewEvent()
    object OnSwipeRefresh : ViewEvent()
    object FetchProfile : ViewEvent()
}

sealed class FetchStatus {
    object Fetching : FetchStatus()
    object Fetched : FetchStatus()
    object NotFetched : FetchStatus()
}
