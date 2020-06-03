package dev.shtanko.algorithms.search

/**
 * In computer science, binary search, also known as half-interval search, logarithmic search, or binary chop, is a
 * search algorithm that finds the position of a target value within a sorted array.
 * Binary search compares the target value to the middle element of the array.
 */
class BinarySearch<T : Comparable<T>> : AbstractSearchStrategy<T> {
    override fun perform(arr: Array<T>, element: T): Int {
        var lo = 0
        var hi = arr.size - 1
        while (lo <= hi) {
            val mid = (lo + hi) / 2
            when {
                element < arr[mid] -> hi = mid - 1
                element > arr[mid] -> lo = mid + 1
                else -> return mid
            }
        }
        return -1
    }
}
