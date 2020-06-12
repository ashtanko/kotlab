package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.utils.measureTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class MemoryTest {
    companion object {
        private const val ARRAY_SIZE = 100_000
    }

    @Test
    @Order(5)
    fun `bubble sort`() {
        execute(BubbleSort(), getSortedArray())
    }

    @Test
    @Order(9)
    fun `bubble sort 2`() {
        execute(SimpleBubbleSort(), getSortedArray())
    }

    @Test
    @Order(6)
    fun `insertion sort`() {
        execute(InsertionSort(), getSortedArray())
    }

    @Test
    @Order(7)
    fun `insertion sort 2`() {
        execute(InsertionSort2(), getSortedArray())
    }

    @Test
    @Order(4)
    fun `merge sort`() {
        execute(MergeSort(), getSortedArray())
    }

    @Test
    @Order(3)
    fun `quick sort`() {
        execute(QuickSort(), getSortedArray())
    }

    @Test
    @Order(8)
    fun `selection sort`() {
        execute(SelectionSort(), getSortedArray())
    }

    @Test
    @Order(2)
    fun `shell sort`() {
        execute(ShellSort(), getSortedArray())
    }

    @Test
    @Order(1)
    fun `heap sort`() {
        execute(HeapSort(), getSortedArray())
    }

    @Test
    @Order(10)
    fun `array sort`() {
        execute(ArraySort(), getSortedArray())
    }

    @Test
    @Order(11)
    fun `pancake sort`() {
        execute(PancakeSort(), getSortedArray())
    }

    @Test
    @Order(12)
    fun `gnome sort`() {
        execute(GnomeSort(), getSortedArray())
    }

    private fun getSortedArray(): IntArray {
        val array = IntArray(ARRAY_SIZE)
        for (i in 0 until ARRAY_SIZE) {
            array[i] = i
        }
        return array
    }

    private fun execute(strategy: AbstractSortStrategy, array: IntArray) {
        measureTime(strategy, array) {
            strategy.perform(array.toTypedArray())
        }
        assertTrue(array.isSorted())
    }
}
