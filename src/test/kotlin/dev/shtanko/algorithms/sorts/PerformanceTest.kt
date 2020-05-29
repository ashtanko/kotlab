package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.random.Random

class PerformanceTest {

    @Test
    fun `bubble sort`() {
        val cases = listOf(10_000, 20_000, 50_000)
        cases.forEach {
            executionTimeReport(BubbleSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `bubble sort 2`() {
        val cases = listOf(10_000, 20_000, 50_000)
        cases.forEach {
            executionTimeReport(BubbleSort2(), generateRandomArray(it))
        }
    }

    @Test
    fun `insertion sort`() {
        val cases = listOf(10_000, 20_000, 50_000)
        cases.forEach {
            executionTimeReport(InsertionSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `insertion sort 2`() {
        val cases = listOf(10_000, 20_000, 50_000)
        cases.forEach {
            executionTimeReport(InsertionSort2(), generateRandomArray(it))
        }
    }

    @Test
    fun `merge sort`() {
        val cases = listOf(10_000, 20_000, 50_000, 100_000, 200_000, 600_000, 1000_000, 10_000_000)
        cases.forEach {
            executionTimeReport(MergeSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `quick sort`() {
        val cases = listOf(10_000, 20_000, 50_000, 100_000, 200_000, 600_000, 1000_000, 10_000_000)
        cases.forEach {
            executionTimeReport(QuickSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `selection sort`() {
        val cases = listOf(10_000, 20_000, 50_000)
        cases.forEach {
            executionTimeReport(SelectionSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `shell sort`() {
        val cases = listOf(10_000, 20_000, 50_000, 100_000, 200_000, 600_000, 1000_000, 10_000_000)
        cases.forEach {
            executionTimeReport(ShellSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `heap sort`() {
        val cases = listOf(10_000, 20_000, 50_000, 100_000, 200_000, 600_000, 1000_000, 10_000_000)
        cases.forEach {
            executionTimeReport(HeapSort(), generateRandomArray(it))
        }
    }

    private fun generateRandomArray(count: Int): Array<Int> {
        val arr = Array<Int>(count) { 0 }
        for (i in 0 until count) {
            arr[i] = Random.nextInt(count)
        }
        return arr
    }

    private fun executionTimeReport(strategy: AbstractSortStrategy, array: Array<Int>) {
        // Run the algorithm
        val startTime = System.nanoTime()
        strategy.perform(array)
        val endTime = System.nanoTime()

        val result = String.format(
            "Arrays of length %d Algorithm %s Strategy %s Time %d",
            array.size,
            "Random",
            strategy.javaClass.simpleName,
            endTime - startTime
        )

        println(result)

        assertTrue(array.isSorted())
    }
}