/*
 * Copyright 2021 Oleksii Shtanko
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

internal abstract class FindDuplicateNumberTest<out T : FindDuplicateNumber>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                0
            ),
            Arguments.of(
                intArrayOf(1),
                0
            ),
            Arguments.of(
                intArrayOf(1, 3, 4, 2, 2),
                2
            ),
            Arguments.of(
                intArrayOf(3, 1, 3, 4, 2),
                3
            ),
            Arguments.of(
                intArrayOf(1, 1),
                1
            ),
            Arguments.of(
                intArrayOf(1, 1, 2),
                1
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `find duplicate number in array test`(nums: IntArray, expected: Int) {
        val actual = strategy.perform(nums)
        assertThat(actual).isEqualTo(expected)
    }
}

internal class FindDuplicateSortTest : FindDuplicateNumberTest<FindDuplicateSort>(FindDuplicateSort())
internal class FindDuplicateSetTest : FindDuplicateNumberTest<FindDuplicateSet>(FindDuplicateSet())
