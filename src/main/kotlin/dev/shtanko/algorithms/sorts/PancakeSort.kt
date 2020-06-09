package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.flip

class PancakeSort : AbstractSortStrategy {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        for (i in arr.indices) {
            var max = arr[0]
            var index = 0

            for (j in 0 until arr.size - i) {
                if (max < arr[j]) {
                    max = arr[j]
                    index = j
                }
            }
            arr.flip(index, arr.size - 1 - i)
        }
    }
}
