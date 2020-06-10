package dev.shtanko.algorithms.search

/**
 * Linear search is an algorithm which finds the position of a target value within an array (Usually unsorted)
 *
 * Worst-case performance       O(n)
 * Best-case performance        O(1)
 * Average performance          O(n)
 * Worst-case space complexity  O(1)
 */
class LinearSearch<T> : AbstractSearchStrategy<T> {

    override fun perform(arr: Array<T>, element: T): Int {
        for ((i, a) in arr.withIndex()) {
            if (a == element) {
                return i
            }
        }
        return -1
    }
}
