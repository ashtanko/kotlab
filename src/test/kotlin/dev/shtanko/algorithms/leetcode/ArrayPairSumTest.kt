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

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class ArrayPairSumTest<out T : PairSumStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf() to 0,
                intArrayOf(1, 4, 3, 2) to 4,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `array pair sum test`(data: Pair<IntArray, Int>) {
        val (arr, expected) = data
        val actual = strategy.perform(arr)
        assertThat(actual, equalTo(expected))
    }
}

internal class PairSumSort1Test : ArrayPairSumTest<PairSumSort1>(PairSumSort1())

internal class PairSumSort2Test : ArrayPairSumTest<PairSumSort2>(PairSumSort2())

internal class PairSumSort3Test : ArrayPairSumTest<PairSumSort3>(PairSumSort3())

internal class PairSumOddTest : ArrayPairSumTest<PairSumOdd>(PairSumOdd())
