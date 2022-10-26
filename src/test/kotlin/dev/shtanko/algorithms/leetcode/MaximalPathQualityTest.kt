/*
 * Copyright 2022 Oleksii Shtanko
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
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class MaximalPathQualityTest<out T : MaximalPathQuality>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 32, 10, 43),
                arrayOf(
                    intArrayOf(0, 1, 10),
                    intArrayOf(1, 2, 15),
                    intArrayOf(0, 3, 10),
                ),
                49,
                75,
            ),
            Arguments.of(
                intArrayOf(5, 10, 15, 20),
                arrayOf(
                    intArrayOf(0, 1, 10),
                    intArrayOf(1, 2, 10),
                    intArrayOf(0, 3, 10),
                ),
                30,
                25,
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                arrayOf(
                    intArrayOf(0, 1, 10),
                    intArrayOf(1, 2, 11),
                    intArrayOf(2, 3, 12),
                    intArrayOf(1, 3, 13),
                ),
                50,
                7,
            ),
            Arguments.of(
                intArrayOf(),
                arrayOf(
                    intArrayOf(),
                ),
                0,
                0,
            ),
            Arguments.of(
                intArrayOf(),
                arrayOf<IntArray>(),
                0,
                0,
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `maximal path quality test`(values: IntArray, edges: Array<IntArray>, maxTime: Int, expected: Int) {
        val actual = strategy.invoke(values, edges, maxTime)
        assertThat(actual).isEqualTo(expected)
    }
}

class MaximalPathQualityDFSTest : MaximalPathQualityTest<MaximalPathQuality>(MaximalPathQualityDFS())
