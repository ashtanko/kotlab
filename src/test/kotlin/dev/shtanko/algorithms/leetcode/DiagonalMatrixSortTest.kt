/*
 * Copyright 2022 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class DiagonalMatrixSortTest<out T : DiagonalMatrixSort>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 3, 1, 1),
                    intArrayOf(2, 2, 1, 2),
                    intArrayOf(1, 1, 1, 2),
                ),
                arrayOf(
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 2, 2, 2),
                    intArrayOf(1, 2, 3, 3),
                ),
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(11, 25, 66, 1, 69, 7),
                    intArrayOf(23, 55, 17, 45, 15, 52),
                    intArrayOf(75, 31, 36, 44, 58, 8),
                    intArrayOf(22, 27, 33, 25, 68, 4),
                    intArrayOf(84, 28, 14, 11, 5, 50),
                ),
                arrayOf(
                    intArrayOf(5, 17, 4, 1, 52, 7),
                    intArrayOf(11, 11, 25, 45, 8, 69),
                    intArrayOf(14, 23, 25, 44, 58, 15),
                    intArrayOf(22, 27, 31, 36, 50, 66),
                    intArrayOf(84, 28, 75, 33, 55, 68),
                ),
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `diagonal sort test`(mat: Array<IntArray>, expected: Array<IntArray>) {
        val actual = strategy.diagonalSort(mat)
        assertThat(actual).isEqualTo(expected)
    }
}

class DiagonalMatrixSortSFTest : DiagonalMatrixSortTest<DiagonalMatrixSort>(DiagonalMatrixSortSF())
class DiagonalMatrixSortSFArrayTest : DiagonalMatrixSortTest<DiagonalMatrixSort>(DiagonalMatrixSortSFArray())
class DiagonalMatrixSortMapTest : DiagonalMatrixSortTest<DiagonalMatrixSort>(DiagonalMatrixSortMap())
