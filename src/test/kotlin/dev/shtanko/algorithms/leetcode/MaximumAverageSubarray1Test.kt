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

import java.lang.Double.NaN
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class MaximumAverageSubArray1Test<out T : FindMaxAverageStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Double>> {
            return listOf(
                intArrayOf() to 0 to NaN,
                intArrayOf(1, 12, -5, -6, 50, 3) to 4 to 12.75,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<IntArray, Int>, Double>) {
        val (data, expected) = testCase
        val (nums, k) = data
        val actual = strategy.perform(nums, k)
        assertEquals(expected, actual)
    }
}

class FindMaxAverage1Test : MaximumAverageSubArray1Test<FindMaxAverage1>(FindMaxAverage1())
class FindMaxAverage2Test : MaximumAverageSubArray1Test<FindMaxAverage2>(FindMaxAverage2())
