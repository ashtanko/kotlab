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

internal abstract class ContainsDuplicate2Test<out T : ContainsDuplicate2>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(), 0, false),
            Arguments.of(intArrayOf(1, 2, 3, 1), 3, true),
            Arguments.of(intArrayOf(1, 0, 1, 1), 1, true),
            Arguments.of(intArrayOf(1, 2, 3, 1, 2, 3), 2, false)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `is contains duplicate test`(arr: IntArray, k: Int, expected: Boolean) {
        val actual = strategy.perform(arr, k)
        assertEquals(expected, actual)
    }
}

internal class ContainsDuplicateLinearTest : ContainsDuplicate2Test<ContainsDuplicateLinear>(ContainsDuplicateLinear())
internal class ContainsDuplicateBinarySearchTreeTest :
    ContainsDuplicate2Test<ContainsDuplicateBinarySearchTree>(ContainsDuplicateBinarySearchTree())

internal class ContainsDuplicateHashTest : ContainsDuplicate2Test<ContainsDuplicateHash>(ContainsDuplicateHash())
