package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.swap

class BubbleSort2 : AbstractSortStrategy {

    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        for (i in 0 until arr.size - 1) {
            for (j in i + 1 until arr.size) {
                if (arr[i] > arr[j]) {
                    arr.swap(i, j)
                }
            }
        }
    }
}
