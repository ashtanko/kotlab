package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.swap

/**
 * Shellsort, also known as Shell sort or Shell's method, is an in-place comparison sort. It can be seen as either a
 * generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort). The method starts by
 * sorting pairs of elements far apart from each other, then progressively reducing the gap between elements to be
 * compared. Starting with far apart elements, it can move some out-of-place elements into position faster than
 * a simple nearest neighbor exchange. Donald Shell published the first version of this sort in 1959.
 * This implementation uses the gap sequence proposed by Pratt in 1971: 1, 4, 13, 40...
 */
class ShellSort : AbstractSortStrategy {

    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        val n = arr.size
        var h = 1
        while (h < n / GAP) {
            h = h * GAP + 1
        }

        while (h >= 1) {
            for (i in h until n) {
                for (j in i downTo h step h) {
                    if (arr[j - h] < arr[j]) break
                    arr.swap(j, j - h)
                }
            }
            h /= GAP
        }
    }

    companion object {
        const val GAP = 3
    }
}
