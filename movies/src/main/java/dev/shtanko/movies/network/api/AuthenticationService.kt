package dev.shtanko.movies.network.api

interface AuthenticationService {
    fun createGuestSession()

    fun createRequestToken()
}
