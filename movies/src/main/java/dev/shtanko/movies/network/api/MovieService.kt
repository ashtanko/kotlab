package dev.shtanko.movies.network.api

import dev.shtanko.movies.network.model.BaseResponse
import dev.shtanko.movies.network.model.VideoListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("/3/movie/{movie_id}/videos")
    fun fetchVideos(@Path("movie_id") id: Int): BaseResponse<VideoListResponse>

    companion object {
        fun create(): MovieService {
            return getRetrofit().create(MovieService::class.java)
        }
    }
}
