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

internal abstract class InvertBinaryTreeStrategyTest<out T : InvertTreeStrategy>(val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<TreeNode, List<List<Int>>>> = listOf(
            TreeNode(4).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                }
                right = TreeNode(7).apply {
                    left = TreeNode(6)
                    right = TreeNode(9)
                }
            } to listOf(
                listOf(4),
                listOf(7, 2),
                listOf(9, 6, 3, 1),
            ),
            TreeNode(4).apply {
                left = TreeNode(2)
                right = TreeNode(7)
            } to listOf(
                listOf(4),
                listOf(7, 2),
            ),
            TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(3)
            } to listOf(
                listOf(1),
                listOf(3, 2),
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `invert binary tree test`(testCase: Pair<TreeNode, List<List<Int>>>) {
        val (tree, expected) = testCase
        val invertedTree = strategy.perform(tree)
        val actual = invertedTree.levelOrder()
        assertEquals(expected, actual)
    }
}

internal class InvertTreeTest : InvertBinaryTreeStrategyTest<InvertTree>(InvertTree())

internal class InvertTreeRecursiveTest : InvertBinaryTreeStrategyTest<InvertTreeRecursive>(InvertTreeRecursive())
