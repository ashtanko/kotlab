package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.swap

class GnomeSort : AbstractSortStrategy {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        var i = 1
        var j = 2
        while (i < arr.size) {
            if (arr[i - 1] < arr[i]) {
                i = j++
            } else {
                arr.swap(i - 1, i)
                if (--i == 0) {
                    i = j++
                }
            }
        }
    }
}
