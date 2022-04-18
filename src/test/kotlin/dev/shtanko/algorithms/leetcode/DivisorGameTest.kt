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
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class DivisorGameTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, Int>> {
            return listOf(
                true to 2,
                false to 3,
                true to 48,
                true to 1000, // or Int.MAX_VALUE
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `divisor game test`(testCase: Pair<Boolean, Int>) {
        val (expected, num) = testCase
        val actual = num.divisorGame()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `divisor game naive test`(testCase: Pair<Boolean, Int>) {
        val (expected, num) = testCase
        val actual = num.divisorGameNaive()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `divisor game brute force test`(testCase: Pair<Boolean, Int>) {
        val (expected, num) = testCase
        val actual = num.divisorGameBruteForce()
        assertEquals(expected, actual)
    }
}
