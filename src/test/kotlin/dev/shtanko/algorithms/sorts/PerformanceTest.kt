package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.utils.measureTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import kotlin.random.Random

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class PerformanceTest {

    private val slowSortCases = listOf(10_000, 20_000, 50_000)
    private val fastSortCases = listOf(10_000, 20_000, 50_000, 100_000, 200_000, 600_000, 1000_000, 10_000_000)

    @Test
    @Order(7)
    fun `bubble sort`() {
        slowSortCases.forEach {
            executionTimeReport(BubbleSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(9)
    fun `bubble sort 2`() {
        slowSortCases.forEach {
            executionTimeReport(SimpleBubbleSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(10)
    fun `array sort`() {
        slowSortCases.forEach {
            executionTimeReport(ArraySort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(11)
    fun `pancake sort`() {
        slowSortCases.forEach {
            executionTimeReport(PancakeSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(12)
    fun `gnome sort`() {
        slowSortCases.forEach {
            executionTimeReport(GnomeSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(6)
    fun `insertion sort`() {
        slowSortCases.forEach {
            executionTimeReport(InsertionSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(8)
    fun `insertion sort 2`() {
        slowSortCases.forEach {
            executionTimeReport(InsertionSort2(), generateRandomArray(it))
        }
    }

    @Test
    @Order(4)
    fun `merge sort`() {
        fastSortCases.forEach {
            executionTimeReport(MergeSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(3)
    fun `quick sort`() {
        fastSortCases.forEach {
            executionTimeReport(QuickSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(5)
    fun `selection sort`() {
        slowSortCases.forEach {
            executionTimeReport(SelectionSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(2)
    fun `shell sort`() {
        fastSortCases.forEach {
            executionTimeReport(ShellSort(), generateRandomArray(it))
        }
    }

    @Test
    @Order(1)
    fun `heap sort`() {
        fastSortCases.forEach {
            executionTimeReport(HeapSort(), generateRandomArray(it))
        }
    }

    private fun generateRandomArray(count: Int): IntArray {
        val array = IntArray(count)
        for (i in 0 until count) {
            array[i] = Random.nextInt(count)
        }
        return array
    }

    private fun executionTimeReport(strategy: AbstractSortStrategy, array: IntArray) {
        val arr = array.toTypedArray()
        measureTime(strategy, array) {
            strategy.perform(arr)
        }
        assertTrue(arr.isSorted())
    }
}
