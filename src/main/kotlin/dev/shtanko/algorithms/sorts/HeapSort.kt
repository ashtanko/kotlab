package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.swap

/**
 * Heap sort is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection
 * sort where we first find the maximum element and place the maximum element at the end. We repeat the same process
 * for remaining element.
 *
 * Worst-case performance       O(n*log(n))
 * Best-case performance        O(n*log(n))
 * Average-case performance     O(n*log(n))
 * Worst-case space complexity  O(1) (auxiliary)
 */
class HeapSort : AbstractSortStrategy {

    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        val n = arr.size
        for (i in n / 2 - 1 downTo 0) {
            heapify(arr, n, i)
        }

        for (i in n - 1 downTo 0) {
            arr.swap(0, i)
            heapify(arr, i, 0)
        }
    }

    private fun <T : Comparable<T>> heapify(arr: Array<T>, n: Int, i: Int) {
        var largest = i
        val l = 2 * i + 1
        val r = 2 * i + 2

        if (l < n && arr[l] > arr[largest]) {
            largest = l
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r
        }

        if (largest != i) {
            arr.swap(i, largest)
            heapify(arr, n, largest)
        }
    }
}
