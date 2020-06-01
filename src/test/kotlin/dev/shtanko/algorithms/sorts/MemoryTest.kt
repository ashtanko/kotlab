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
    fun `quick sort`() {
        execute(QuickSort(), getSortedArray())
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