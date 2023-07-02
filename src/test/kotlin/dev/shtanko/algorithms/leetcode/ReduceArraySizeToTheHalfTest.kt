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

abstract class ReduceArraySizeToTheHalfTest<out T : MinSetSizeStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7) to 2,
                intArrayOf(7, 7, 7, 7, 7, 7) to 1,
                intArrayOf(1, 9) to 1,
                intArrayOf(1000, 1000, 3, 7) to 1,
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) to 5,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

class MinSetSizeHashMapTest : ReduceArraySizeToTheHalfTest<MinSetSizeHashMap>(MinSetSizeHashMap())

class MinSetSizePriorityQueueTest :
    ReduceArraySizeToTheHalfTest<MinSetSizePriorityQueue>(MinSetSizePriorityQueue())
