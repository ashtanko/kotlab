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

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CombinationSumTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, List<List<Int>>>> {
            return listOf(
                intArrayOf(2, 3, 6, 7) to 7 to listOf(listOf(2, 2, 3), listOf(7)),
                intArrayOf(2, 3, 5) to 8 to listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5)),
            )
        }
    }

    @ExperimentalStdlibApi
    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `combination sum test`(testCase: Pair<Pair<IntArray, Int>, List<List<Int>>>) {
        val (data, expected) = testCase
        val (candidates, target) = data
        val actual = combinationSum(candidates, target)
        assertThat(actual, `is`(expected))
        assertEquals(expected, actual)
    }
}
