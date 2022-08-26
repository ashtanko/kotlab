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

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource

internal abstract class CandyTest<out T : CandyStrategy>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> = listOf(
            intArrayOf() to 0,
            intArrayOf(1, 0, 2) to 5,
            intArrayOf(1, 2, 2) to 4,
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `candy test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

internal class CandyBruteForceTest : CandyTest<CandyBruteForce>(CandyBruteForce())
internal class Candy2ArraysTest : CandyTest<Candy2Arrays>(Candy2Arrays())
internal class CandyArrayTest : CandyTest<CandyArray>(CandyArray())
internal class CandyMathTest : CandyTest<CandyMath>(CandyMath())
