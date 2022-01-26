package dev.shtanko.concurrency

import dev.shtanko.algorithms.sorts.MergeSort
import dev.shtanko.utils.merge
import java.util.concurrent.RecursiveAction

class ParallelSmartMergeSort(
    val array: IntArray,
    val low: Int,
    val high: Int,
) : RecursiveAction() {
    private val helper = IntArray(array.size)
    private val arr = array.toTypedArray()

    override fun compute() {
        if (low < high) {
            if (high - low <= MAX) {
                MergeSort().perform(arr)
            } else {
                val mid = low.plus(high).div(2)
                val left = ParallelSmartMergeSort(array, low, mid)
                val right = ParallelSmartMergeSort(array, mid + 1, high)
                invokeAll(left, right)
                merge(array, helper, low, mid, high)
            }
        }
    }

    companion object {
        private const val MAX = 1 shl 13
    }
}
