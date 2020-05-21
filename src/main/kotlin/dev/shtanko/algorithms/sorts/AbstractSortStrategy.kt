package dev.shtanko.algorithms.sorts

abstract class AbstractSortStrategy {
    abstract fun <T : Comparable<T>> perform(arr: Array<T>)
}