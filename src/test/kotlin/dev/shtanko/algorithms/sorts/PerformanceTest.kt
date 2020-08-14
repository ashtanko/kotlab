package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.generateRandomArray
import dev.shtanko.algorithms.utils.measureTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class PerformanceTest {

    // private val slowSortCases = listOf(10_000, 20_000, 50_000)
    // private val fastSortCases = listOf(10_000, 20_000, 50_000, 100_000, 200_000, 600_000, 1000_000, 10_000_000)

    private val slowSortCases = listOf(500, 600, 800) // only for ci for faster testing
    private val fastSortCases = listOf(30_000, 50_000) // only for ci for faster testing

    @Test
    @Order(7)
    fun `bubble sort`() {
        slowSortCases.forEach {
            executionTimeReport(BubbleSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(9)
    fun `bubble sort 2`() {
        slowSortCases.forEach {
            executionTimeReport(SimpleBubbleSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(10)
    fun `array sort`() {
        slowSortCases.forEach {
            executionTimeReport(ArraySort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(11)
    fun `pancake sort`() {
        slowSortCases.forEach {
            executionTimeReport(PancakeSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(12)
    fun `gnome sort`() {
        slowSortCases.forEach {
            executionTimeReport(GnomeSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(6)
    fun `insertion sort`() {
        slowSortCases.forEach {
            executionTimeReport(InsertionSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(8)
    fun `insertion sort 2`() {
        slowSortCases.forEach {
            executionTimeReport(InsertionSort2(), it.generateRandomArray())
        }
    }

    @Test
    @Order(4)
    fun `merge sort`() {
        fastSortCases.forEach {
            executionTimeReport(MergeSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(3)
    fun `quick sort`() {
        fastSortCases.forEach {
            executionTimeReport(QuickSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(5)
    fun `selection sort`() {
        slowSortCases.forEach {
            executionTimeReport(SelectionSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(2)
    fun `shell sort`() {
        fastSortCases.forEach {
            executionTimeReport(ShellSort(), it.generateRandomArray())
        }
    }

    @Test
    @Order(1)
    fun `heap sort`() {
        fastSortCases.forEach {
            executionTimeReport(HeapSort(), it.generateRandomArray())
        }
    }

    private fun executionTimeReport(strategy: AbstractSortStrategy, array: IntArray) {
        val arr = array.toTypedArray()
        measureTime(strategy, array) {
            strategy.perform(arr)
        }
        assertTrue(arr.isSorted())
    }
}
