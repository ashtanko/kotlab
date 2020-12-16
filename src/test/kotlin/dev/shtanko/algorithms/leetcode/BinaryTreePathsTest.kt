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

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class BinaryTreePathsTest<out T : BinaryTreePathsStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    TreeNode(1).apply {
                        left = TreeNode(2)
                        right = TreeNode(3)
                        left?.right = TreeNode(5)
                    },
                    listOf("1->2->5", "1->3")
                ),
                Arguments.of(
                    t2(),
                    listOf("1->2->4", "1->2->5", "1->3->6", "1->3->7")
                ),
            )
        }

        private fun t2(): TreeNode? {
            val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            val tree: TreeNode? = null
            return insertLevelOrder(tree, arr, 0)
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `binary tree paths test`(tree: TreeNode, expected: List<String>) {
        val actual = strategy.binaryTreePaths(tree).sorted()
        assertEquals(expected, actual)
    }
}

internal class BinaryTreePathsRecursionTest : BinaryTreePathsTest<BinaryTreePathsRecursion>(BinaryTreePathsRecursion())

internal class BinaryTreePathsBFSQueueTest : BinaryTreePathsTest<BinaryTreePathsBFSQueue>(BinaryTreePathsBFSQueue())

internal class BinaryTreePathsBFSStackTest : BinaryTreePathsTest<BinaryTreePathsBFSStack>(BinaryTreePathsBFSStack())
