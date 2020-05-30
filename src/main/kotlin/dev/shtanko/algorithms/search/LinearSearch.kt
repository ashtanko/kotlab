package dev.shtanko.algorithms.search

/**
 * The time complexity of above algorithm is O(n).
 * Linear search is rarely used practically because other search algorithms such as the binary search algorithm and
 * hash tables allow significantly faster searching comparison to Linear search.
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
