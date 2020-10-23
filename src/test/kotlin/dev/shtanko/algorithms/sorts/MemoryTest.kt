package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.utils.measureTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MemoryTest {
    companion object {
        // 1000_000 //uncomment for original test
        private const val ARRAY_SIZE = 1000

        @JvmStatic
        fun dataProvider(): List<AbstractSortStrategy> {
            return listOf(
                BubbleSort(),
                SimpleBubbleSort(),
                InsertionSort(),
                InsertionSort2(),
                MergeSort(),
                QuickSort(),
                SelectionSort(),
                ShellSort(),
                HeapSort(),
                ArraySort(),
                PancakeSort(),
                GnomeSort()
            )
        }

        private fun getSortedArray(): IntArray {
            val array = IntArray(ARRAY_SIZE)
            for (i in 0 until ARRAY_SIZE) {
                array[i] = i
            }
            return array
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `sorts test`(testCase: AbstractSortStrategy) {
        execute(testCase, getSortedArray())
    }

    private fun execute(strategy: AbstractSortStrategy, array: IntArray) {
        measureTime(strategy, array) {
            strategy.perform(array.toTypedArray())
        }
        assertTrue(array.isSorted())
    }
}
