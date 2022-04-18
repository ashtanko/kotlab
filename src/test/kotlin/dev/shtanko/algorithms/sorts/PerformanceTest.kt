/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.sorts

import dev.shtanko.algorithms.extensions.generateRandomArray
import dev.shtanko.algorithms.utils.measureTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PerformanceTest {

    internal class SlowSortsArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(BubbleSort(), hundred),
            Arguments.of(BubbleSort(), fiveHundred),
            Arguments.of(BubbleSort(), eightHundred),
            Arguments.of(SimpleBubbleSort(), hundred),
            Arguments.of(SimpleBubbleSort(), fiveHundred),
            Arguments.of(SimpleBubbleSort(), eightHundred),
            Arguments.of(ArraySort(), hundred),
            Arguments.of(ArraySort(), fiveHundred),
            Arguments.of(ArraySort(), eightHundred),
            Arguments.of(PancakeSort(), hundred),
            Arguments.of(PancakeSort(), fiveHundred),
            Arguments.of(PancakeSort(), eightHundred),
            Arguments.of(GnomeSort(), hundred),
            Arguments.of(GnomeSort(), fiveHundred),
            Arguments.of(GnomeSort(), eightHundred),
            Arguments.of(InsertionSort(), hundred),
            Arguments.of(InsertionSort(), fiveHundred),
            Arguments.of(InsertionSort(), eightHundred),
            Arguments.of(InsertionSort2(), hundred),
            Arguments.of(InsertionSort2(), fiveHundred),
            Arguments.of(InsertionSort2(), eightHundred),
            Arguments.of(SelectionSort(), hundred),
            Arguments.of(SelectionSort(), fiveHundred),
            Arguments.of(SelectionSort(), eightHundred),
            Arguments.of(StableSelectionSort(), hundred),
            Arguments.of(StableSelectionSort(), fiveHundred),
            Arguments.of(StableSelectionSort(), eightHundred),
        )

        private val hundred = 100.generateRandomArray()
        private val fiveHundred = 500.generateRandomArray()
        private val eightHundred = 800.generateRandomArray()
    }

    internal class FastSortsArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(mergeSortStrategy, thirtyK),
            Arguments.of(mergeSortStrategy, fiftyK),
            Arguments.of(mergeSortStrategy, hundredK),
            Arguments.of(mergeSortStrategy, fiveHundredK),
            Arguments.of(quickSortStrategy, thirtyK),
            Arguments.of(quickSortStrategy, fiftyK),
            Arguments.of(quickSortStrategy, hundredK),
            Arguments.of(quickSortStrategy, fiveHundredK),
            Arguments.of(shellSortStrategy, thirtyK),
            Arguments.of(shellSortStrategy, fiftyK),
            Arguments.of(shellSortStrategy, hundredK),
            Arguments.of(shellSortStrategy, fiveHundredK),
            Arguments.of(heapSortStrategy, thirtyK),
            Arguments.of(heapSortStrategy, fiftyK),
            Arguments.of(heapSortStrategy, hundredK),
            Arguments.of(heapSortStrategy, fiveHundredK)
        )

        private val mergeSortStrategy = MergeSort()
        private val quickSortStrategy = QuickSort()
        private val shellSortStrategy = ShellSort()
        private val heapSortStrategy = HeapSort()

        private val thirtyK = 30_000.generateRandomArray()
        private val fiftyK = 50_000.generateRandomArray()
        private val hundredK = 100_000.generateRandomArray()
        private val fiveHundredK = 500_000.generateRandomArray()
    }

    @ParameterizedTest
    @ArgumentsSource(SlowSortsArgumentsProvider::class)
    internal fun `slow sorts test`(strategy: AbstractSortStrategy, arr: IntArray) {
        executionTimeReport(strategy, arr)
    }

    @ParameterizedTest
    @ArgumentsSource(FastSortsArgumentsProvider::class)
    internal fun `fast sorts test`(strategy: AbstractSortStrategy, arr: IntArray) {
        executionTimeReport(strategy, arr)
    }

    private fun executionTimeReport(strategy: AbstractSortStrategy, array: IntArray) {
        val arr = array.toTypedArray()
        measureTime(strategy, array) {
            strategy.perform(arr)
        }
        assertTrue(arr.isSorted())
    }
}
