package dev.shtanko.algorithms.sorts

import java.util.*

class ArraySort : AbstractSortStrategy {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        Arrays.sort(arr)
    }
}
