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

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class KHTFactorTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, Int>, Int>> {
            return listOf(
                12 to 3 to 3,
                7 to 2 to 7,
                4 to 4 to -1,
                1 to 1 to 1,
                1000 to 3 to 4,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `kth factor test`(testCase: Pair<Pair<Int, Int>, Int>) {
        val (data, expected) = testCase
        val (n, k) = data
        val actual = kthFactor(n, k)
        assertEquals(expected, actual)
    }
}
