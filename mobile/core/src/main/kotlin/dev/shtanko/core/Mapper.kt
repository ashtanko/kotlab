package dev.shtanko.core

interface Mapper<From, To> {
    suspend fun map(from: From): To
}
