/*
 * Copyright 2021 Alexey Shtanko
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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class LengthOfLISTest<out T : LengthOfLIS>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18), 4),
            Arguments.of(intArrayOf(0, 1, 0, 3, 2, 3), 4),
            Arguments.of(intArrayOf(7, 7, 7, 7, 7, 7, 7), 1),
            Arguments.of(intArrayOf(1, 2, 3), 3),
            Arguments.of(intArrayOf(), 0),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `length of longest increasing subsequence test`(nums: IntArray, expected: Int) {
        val actual = strategy.perform(nums)
        assertThat(actual).isEqualTo(expected)
    }
}

class LISDPTest : LengthOfLISTest<LISStrategy.DynamicProgramming>(LISStrategy.DynamicProgramming)
class LISBuildSubsequenceTest : LengthOfLISTest<LISStrategy.BuildSubsequence>(LISStrategy.BuildSubsequence)
class LISBinarySearchTest : LengthOfLISTest<LISStrategy.BinarySearch>(LISStrategy.BinarySearch)
