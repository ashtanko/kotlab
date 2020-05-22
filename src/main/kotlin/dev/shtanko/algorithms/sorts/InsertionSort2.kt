package dev.shtanko.algorithms.sorts

/**
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * Each iteration, insertion sort removes one element from the input data, finds the location it belongs within
 * the sorted list, and inserts it there. It repeats until no input elements remain.
 */
class InsertionSort2 : AbstractSortStrategy {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        for (i in 1 until arr.size) {
            val x = arr[i]
            var j = i
            while (j > 0 && arr[j - 1] > x) {
                arr[j] = arr[j - 1]
                j--
            }
            arr[j] = x
        }
    }
}
