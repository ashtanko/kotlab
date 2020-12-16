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
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class KClosestPointsTest<out T : KClosestPointsStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Array<IntArray>, Int>, Array<IntArray>>> = listOf(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(-2, 2)
            ) to 1 to arrayOf(intArrayOf(-2, 2)),
            arrayOf(
                intArrayOf(3, 3),
                intArrayOf(5, -1),
                intArrayOf(-2, 4)
            ) to 2 to arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4)),
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `K closest points test`(testCase: Pair<Pair<Array<IntArray>, Int>, Array<IntArray>>) {
        val (data, expected) = testCase
        val (points, k) = data
        val actual = strategy.perform(points, k)
        assertArrayEquals(expected, actual)
    }
}

internal class KClosestPointsQueueTest : KClosestPointsTest<KClosestPointsQueue>(KClosestPointsQueue())
internal class KClosestPointsSortTest : KClosestPointsTest<KClosestPointsSort>(KClosestPointsSort())
