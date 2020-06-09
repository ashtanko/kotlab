package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.flip

/**
 * Pancake sorting is the colloquial term for the mathematical problem of sorting a disordered stack of pancakes in
 * order of size when a spatula can be inserted at any point in the stack and used to flip all pancakes above it.
 * A pancake number is the minimum number of flips required for a given number of pancakes.
 */
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
