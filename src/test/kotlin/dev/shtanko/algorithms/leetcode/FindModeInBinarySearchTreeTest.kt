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

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class FindModeInBinarySearchTreeTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }

    companion object {

        @JvmStatic
        fun dataProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1),
                intArrayOf(1)
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        left = TreeNode(2)
                    }
                },
                intArrayOf(2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `find mode in binary search tree test`(root: TreeNode, expected: IntArray) {
        val actual = FindModeInBinarySearchTree().perform(root)
        assertArrayEquals(actual, expected)
    }
}
