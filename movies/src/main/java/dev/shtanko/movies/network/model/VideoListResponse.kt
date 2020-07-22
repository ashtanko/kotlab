package dev.shtanko.movies.network.model

data class VideoListResponse(
    val id: Int,
    val results: List<Video>
) : NetworkResponseModel
