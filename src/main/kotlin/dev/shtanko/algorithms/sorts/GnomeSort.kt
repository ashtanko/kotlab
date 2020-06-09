package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.swap

/**
 * @link(https://en.wikipedia.org/wiki/Gnome_sort)
 * Gnome sort (dubbed stupid sort) is a sorting algorithm originally proposed by an Iranian computer scientist
 *  Hamid Sarbazi-Azad (professor of Computer Science and Engineering at Sharif University of Technology)[1] in 2000.
 */
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
