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

abstract class MaximumDepthOfBinaryTreeTest<out T : MaxDepthStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<TreeNode, Int>> {
            return listOf(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                } to 3,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `maximum depth of binary tree test`(testCase: Pair<TreeNode, Int>) {
        val (root, expected) = testCase
        val actual = strategy.invoke(root)
        assertEquals(expected, actual)
    }
}

class MaxDepthRecursiveTest : MaximumDepthOfBinaryTreeTest<MaxDepthRecursive>(MaxDepthRecursive())
class MaxDepthIterativeTest : MaximumDepthOfBinaryTreeTest<MaxDepthIterative>(MaxDepthIterative())
