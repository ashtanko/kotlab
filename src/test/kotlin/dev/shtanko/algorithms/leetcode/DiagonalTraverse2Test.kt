/*
 * Copyright 2023 Oleksii Shtanko
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

package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class DiagonalTraverse2Test<out T : DiagonalTraverse2>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3),
                    listOf(4, 5, 6),
                    listOf(7, 8, 9),
                ),
                intArrayOf(1, 4, 2, 7, 5, 3, 8, 6, 9),
            ),
            Arguments.of(
                listOf(
                    listOf(1, 2, 3, 4, 5),
                    listOf(6, 7),
                    listOf(8),
                    listOf(9, 10, 11),
                    listOf(12, 13, 14, 15, 16),
                ),
                intArrayOf(1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16),
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `find diagonal order test`(nums: List<List<Int>>, expected: IntArray) {
        val actual = strategy(nums)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class DiagonalTraverse2GroupTest : DiagonalTraverse2Test<DiagonalTraverse2>(DiagonalTraverse2Group())
class DiagonalTraverse2BFSTest : DiagonalTraverse2Test<DiagonalTraverse2>(DiagonalTraverse2BFS())
