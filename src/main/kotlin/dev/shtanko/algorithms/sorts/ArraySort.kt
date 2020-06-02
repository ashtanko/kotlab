package dev.shtanko.algorithms.sorts

class ArraySort : AbstractSortStrategy {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        arr.sort()
    }
}
