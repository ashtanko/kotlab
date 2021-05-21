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
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class AbstractDecodeWays2StrategyTest<out T : DecodeWays2Strategy>(private val strategy: DecodeWays2Strategy) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("", 0),
            Arguments.of("0", 0),
            Arguments.of("1", 1),
            Arguments.of("2", 1),
            Arguments.of("4", 1),
            Arguments.of("7", 1),
            Arguments.of("10", 1),
            Arguments.of("11", 2),
            Arguments.of("*", 9),
            Arguments.of("1*", 18)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `simple test`(str: String, expected: Int) {
        val actual = strategy.perform(str)
        assertEquals(expected, actual)
    }
}

internal class DecodeWays2RecursionWithMemoizationTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2RecursionWithMemoization>(DecodeWays2RecursionWithMemoization())

internal class DecodeWays2DynamicProgrammingTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2DynamicProgramming>(DecodeWays2DynamicProgramming())

internal class DecodeWays2ConstantSpaceDynamicProgrammingTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2ConstantSpaceDynamicProgramming>(
        DecodeWays2ConstantSpaceDynamicProgramming()
    )
