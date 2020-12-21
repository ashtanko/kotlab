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

package dev.shtanko.algorithms.interview.traversals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal abstract class TreeTraversalTest<out T : TreeTraversalStrategy>(private val strategy: T) {
    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    bstRoot,
                    listOf(1, 3, 4, 6, 7, 8, 10, 13, 14)
                )
            )
        }

        //          8
        //         / \
        //        3   10
        //       / \    \
        //      1   6    14
        //         / \   /
        //        4   7 13
        private val bstRoot = BinaryTreeNode(
            data = 8,
            left = BinaryTreeNode(
                data = 3,
                left = BinaryTreeNode(data = 1),
                right = BinaryTreeNode(
                    data = 6,
                    left = BinaryTreeNode(data = 4),
                    right = BinaryTreeNode(data = 7)
                )
            ),
            right = BinaryTreeNode(
                data = 10,
                right = BinaryTreeNode(
                    data = 14,
                    left = BinaryTreeNode(data = 13)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `in order iterative test`(root: BinaryTreeNode, expected: List<Int>) {
        val actual = strategy.inOrderIterative(root)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `in order iterative using stack test`(root: BinaryTreeNode, expected: List<Int>) {
        val actual = strategy.inOrderIterativeStack(root)
        assertEquals(expected, actual)
    }
}

internal class TreeTraversalImplTest : TreeTraversalTest<TreeTraversal>(TreeTraversal())
