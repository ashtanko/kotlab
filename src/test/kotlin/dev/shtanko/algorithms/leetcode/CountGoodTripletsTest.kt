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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CountGoodTripletsTest {

    companion object {

        @JvmStatic
        private fun provideNumbers(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    intArrayOf(),
                    0,
                    0,
                    0,
                    0
                ),
                Arguments.of(
                    intArrayOf(3, 0, 1, 1, 9, 7),
                    7,
                    2,
                    3,
                    4
                ),
                Arguments.of(
                    intArrayOf(1, 1, 2, 2, 3),
                    0,
                    0,
                    1,
                    0
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    internal fun `count good triplets test`(arr: IntArray, a: Int, b: Int, c: Int, expected: Int) {
        val actual = countGoodTriplets(arr, a, b, c)
        assertEquals(expected, actual)
    }
}
