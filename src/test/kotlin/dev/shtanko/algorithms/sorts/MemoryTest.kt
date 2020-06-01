package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MemoryTest {
    companion object {
        private const val ARRAY_SIZE = 100_000
    }

    @Test
    fun `bubble sort`() {
        execute(BubbleSort(), getSortedArray())
    }

    @Test
    fun `bubble sort 2`() {
        execute(BubbleSort2(), getSortedArray())
    }

    @Test
    fun `insertion sort`() {
        execute(InsertionSort(), getSortedArray())
    }

    @Test
    fun `insertion sort 2`() {
        execute(InsertionSort2(), getSortedArray())
    }

    @Test
    fun `merge sort`() {
        execute(MergeSort(), getSortedArray())
    }

    @Test
    fun `quick sort`() {
        execute(QuickSort(), getSortedArray())
    }

    @Test
    fun `selection sort`() {
        execute(SelectionSort(), getSortedArray())
    }

    @Test
    fun `shell sort`() {
        execute(ShellSort(), getSortedArray())
    }

    @Test
    fun `heap sort`() {
        execute(HeapSort(), getSortedArray())
    }

    private fun getSortedArray(): Array<Int> {
        val array = Array(ARRAY_SIZE) { 0 }
        for (i in 0 until ARRAY_SIZE) {
            array[i] = i
        }
        return array
    }

    private fun execute(strategy: AbstractSortStrategy, array: Array<Int>) {
        val startTime = System.nanoTime()
        strategy.perform(array)
        val endTime = System.nanoTime()

        val result = String.format(
            "Arrays of length %d Algorithm %s Strategy %s Time %d",
            array.size,
            "Sorted",
            strategy.javaClass.simpleName,
            endTime - startTime
        )

        println(result)
        Assertions.assertTrue(array.isSorted())
    }
}