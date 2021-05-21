/*
 * Copyright 2020 Alexey Shtanko
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

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CreateTargetArrayTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, IntArray>> {
            return listOf(
                intArrayOf() to intArrayOf() to intArrayOf(),
                intArrayOf(0, 1, 2, 3, 4) to intArrayOf(0, 1, 2, 2, 1) to intArrayOf(0, 4, 1, 3, 2),
                intArrayOf(1, 2, 3, 4, 0) to intArrayOf(0, 1, 2, 3, 0) to intArrayOf(0, 1, 2, 3, 4),
                intArrayOf(1) to intArrayOf(0) to intArrayOf(1),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `create target array solution test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val (pair, expected) = testCase
        val actual = pair.createTargetArray()
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `create target array solution 2 test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val (pair, expected) = testCase
        val actual = pair.createTargetArray2()
        assertArrayEquals(expected, actual)
    }
}
