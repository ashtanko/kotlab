package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.random.Random

class PerformanceTest {

    private val slowSortCases = listOf(10_000, 20_000, 50_000)
    private val fastSortCases = listOf(10_000, 20_000, 50_000, 100_000, 200_000, 600_000, 1000_000, 10_000_000)

    @Test
    fun `bubble sort`() {
        slowSortCases.forEach {
            executionTimeReport(BubbleSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `bubble sort 2`() {
        slowSortCases.forEach {
            executionTimeReport(BubbleSort2(), generateRandomArray(it))
        }
    }

    @Test
    fun `insertion sort`() {
        slowSortCases.forEach {
            executionTimeReport(InsertionSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `insertion sort 2`() {
        slowSortCases.forEach {
            executionTimeReport(InsertionSort2(), generateRandomArray(it))
        }
    }

    @Test
    fun `merge sort`() {
        fastSortCases.forEach {
            executionTimeReport(MergeSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `quick sort`() {
        fastSortCases.forEach {
            executionTimeReport(QuickSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `selection sort`() {
        slowSortCases.forEach {
            executionTimeReport(SelectionSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `shell sort`() {
        fastSortCases.forEach {
            executionTimeReport(ShellSort(), generateRandomArray(it))
        }
    }

    @Test
    fun `heap sort`() {
        fastSortCases.forEach {
            executionTimeReport(HeapSort(), generateRandomArray(it))
        }
    }

    private fun generateRandomArray(count: Int): Array<Int> = Array(count) { Random.nextInt(count) }

    private fun executionTimeReport(strategy: AbstractSortStrategy, array: Array<Int>) {
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