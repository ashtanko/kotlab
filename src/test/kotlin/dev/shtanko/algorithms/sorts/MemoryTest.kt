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

import dev.shtanko.algorithms.utils.measureTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MemoryTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }

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
    internal fun `sorts test`(testCase: AbstractSortStrategy) {
        execute(testCase, getSortedArray())
    }

    private fun execute(strategy: AbstractSortStrategy, array: IntArray) {
        measureTime(strategy, array) {
            strategy.perform(array.toTypedArray())
        }
        assertTrue(array.isSorted())
    }
}
