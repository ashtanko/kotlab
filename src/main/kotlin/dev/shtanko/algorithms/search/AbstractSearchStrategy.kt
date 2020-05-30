package dev.shtanko.algorithms.search

interface AbstractSearchStrategy<T> {
    fun perform(arr: Array<T>, element: T): Int
}
