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
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class UnivaluedBinaryTreeStrategyTest<out T : UnivaluedBinaryTreeStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, TreeNode>> {
            return listOf(
                true to TreeNode(1).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(1)
                        right = TreeNode(1)
                    }
                    right = TreeNode(1).apply {
                        right = TreeNode(1)
                    }
                },
                false to TreeNode(2).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(5)
                        right = TreeNode(2)
                    }
                    right = TreeNode(2)
                }
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `univalued binary tree test`(testCase: Pair<Boolean, TreeNode>) {
        val (expected, tree) = testCase
        val actual = strategy.perform(tree)
        assertEquals(expected, actual)
    }
}

internal class UnivaluedBinaryTreeDFSTest :
    UnivaluedBinaryTreeStrategyTest<UnivaluedBinaryTreeDFS>(UnivaluedBinaryTreeDFS())

internal class UnivaluedBinaryTreeRecursiveTest :
    UnivaluedBinaryTreeStrategyTest<UnivaluedBinaryTreeRecursive>(UnivaluedBinaryTreeRecursive())
