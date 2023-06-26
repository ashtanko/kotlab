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
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class ContainsDuplicateTest<out T : ContainsDuplicateStrategy>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(), false),
            Arguments.of(intArrayOf(1, 2, 3, 1), true),
            Arguments.of(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2), true),
            Arguments.of(intArrayOf(1, 2, 3, 4), false),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `duplicate items test`(arr: IntArray, expected: Boolean) {
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

internal class IsContainsDuplicateSortSetSizeTest :
    ContainsDuplicateTest<IsContainsDuplicateSortSetSize>(IsContainsDuplicateSortSetSize())

internal class IsContainsDuplicateBrutForceTest :
    ContainsDuplicateTest<IsContainsDuplicateBrutForce>(IsContainsDuplicateBrutForce())

internal class IsContainsDuplicateSortTest :
    ContainsDuplicateTest<IsContainsDuplicateSort>(IsContainsDuplicateSort())

internal class IsContainsDuplicateSortSetTest :
    ContainsDuplicateTest<IsContainsDuplicateSortSet>(IsContainsDuplicateSortSet())

internal class IsContainsDuplicateSortSetOptimizedTest :
    ContainsDuplicateTest<IsContainsDuplicateSortSetOptimized>(IsContainsDuplicateSortSetOptimized())

internal class IsContainsDuplicateBitManipulationTest :
    ContainsDuplicateTest<IsContainsDuplicateBitManipulation>(IsContainsDuplicateBitManipulation())
