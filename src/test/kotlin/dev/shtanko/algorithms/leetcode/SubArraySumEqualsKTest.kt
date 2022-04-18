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
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class SubArraySumStrategyTest<out T : SubarraySumStrategy>(private val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0),
                0,
                1
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                2,
                2
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `sub array sum test`(arr: IntArray, k: Int, expected: Int) {
        val actual = strategy.perform(arr, k)
        assertEquals(expected, actual)
    }
}

internal class SubArraySumBruteForceTest : SubArraySumStrategyTest<SubarraySumBruteForce>(SubarraySumBruteForce())

internal class SubArraySumUsingCumulativeSumTest :
    SubArraySumStrategyTest<SubarraySumUsingCumulativeSum>(SubarraySumUsingCumulativeSum())

internal class SubArraySumWithoutSpaceTest : SubArraySumStrategyTest<SubarraySumWithoutSpace>(SubarraySumWithoutSpace())

internal class SubArraySumUsingHashmapTest : SubArraySumStrategyTest<SubarraySumUsingHashmap>(SubarraySumUsingHashmap())
