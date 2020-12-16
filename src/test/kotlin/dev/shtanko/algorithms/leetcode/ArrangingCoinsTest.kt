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

internal abstract class ArrangingCoinsTest<out T : ArrangingCoinsStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, Int>> {
            return listOf(
                5 to 2,
                8 to 3,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `simple test`(testCase: Pair<Int, Int>) {
        val (coins, expected) = testCase
        val actual = strategy.arrangeCoins(coins)
        assertThat(actual, equalTo(expected))
    }
}

internal class ArrangingCoinsMathTest : ArrangingCoinsTest<ArrangingCoinsMath>(ArrangingCoinsMath())

internal class ArrangingCoinsBSTest : ArrangingCoinsTest<ArrangingCoinsBS>(ArrangingCoinsBS())
