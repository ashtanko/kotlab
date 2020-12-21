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

package dev.shtanko.algorithms.dp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class FibonacciSequenceTest {

    companion object {

        @JvmStatic
        fun numberProvider(): List<Pair<Int, Long>> = listOf(
            0 to 0L,
            1 to 1L,
            2 to 1L,
            3 to 2L,
            4 to 3L,
            5 to 5L,
            6 to 8L,
            7 to 13L,
            8 to 21L
        )

        @JvmStatic
        fun sequenceProvider() = listOf(
            1 to listOf(0),
            10 to listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34),
            22 to listOf(
                0,
                1,
                1,
                2,
                3,
                5,
                8,
                13,
                21,
                34,
                55,
                89,
                144,
                233,
                377,
                610,
                987,
                1597,
                2584,
                4181,
                6765,
                10946
            )
        )
    }

    @ParameterizedTest
    @MethodSource("numberProvider")
    internal fun `fibonacci number test`(testCase: Pair<Int, Long>) {
        val actual = fibonacciAt(testCase.first)
        val expected = testCase.second
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("sequenceProvider")
    internal fun `fibonacci sequence test`(testCase: Pair<Int, List<Int>>) {
        val n = testCase.first
        val actual = fibonacci().take(n).toList()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
