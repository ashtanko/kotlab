package dev.shtanko.algorithms.sorts

interface AbstractSortStrategy {
    fun <T : Comparable<T>> perform(arr: Array<T>)
}
