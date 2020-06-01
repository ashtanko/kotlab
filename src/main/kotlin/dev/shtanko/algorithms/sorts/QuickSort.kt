package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.swap

/**
 * Developed by Tony Hoare in 1959, with his work published in 1961, Quicksort is an efficient sort algorithm using
 * divide and conquer approach. Quicksort first divides a large array into two smaller sub-arrays: the low elements
 * and the high elements. Quicksort can then recursively sort the sub-arrays. The steps are:
 * 1) Pick an element, called a pivot, from the array.
 * 2) Partitioning: reorder the array so that all elements with values less than the pivot come before the pivot,
 * while all elements with values greater than the pivot come after it (equal values can go either way).
 * After this partitioning, the pivot is in its final position. This is called the partition operation.
 * 3) Recursively apply the above steps to the sub-array of elements with smaller values and separately to
 * the sub-array of elements with greater values.
 */
class QuickSort : AbstractSortStrategy {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        sort(arr, 0, arr.size - 1)
    }

    private fun <T : Comparable<T>> sort(arr: Array<T>, lo: Int, hi: Int) {
        if (arr.isEmpty()) return

        val divideIndex = partition(arr, lo, hi)

        if (lo < divideIndex - 1) { // 2) Sorting left half
            sort(arr, lo, divideIndex - 1)
        }
        if (divideIndex < hi) { // 3) Sorting right half
            sort(arr, divideIndex, hi)
        }
    }

    private fun <T : Comparable<T>> partition(array: Array<T>, lo: Int, hi: Int): Int {
        var left = lo
        var right = hi
        val pivot = array[(left + right) / 2] // 4) Pivot Point
        while (left <= right) {
            while (array[left] < pivot) left++ // 5) Find the elements on left that should be on right

            while (array[right] > pivot) right-- // 6) Find the elements on right that should be on left

            // 7) Swap elements, and move left and right indices
            if (left <= right) {
                array.swap(left, right)
                left++
                right--
            }
        }
        return left
    }
}
