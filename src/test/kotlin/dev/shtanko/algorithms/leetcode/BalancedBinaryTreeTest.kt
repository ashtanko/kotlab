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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class BalancedBinaryTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, TreeNode>> {
            return listOf(
                true to TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                false to TreeNode(1).apply {
                    right = TreeNode(2)
                    left = TreeNode(2).apply {
                        right = TreeNode(3)
                        left = TreeNode(3).apply {
                            left = TreeNode(4)
                            right = TreeNode(4)
                        }
                    }
                },
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is balanced test`(testCase: Pair<Boolean, TreeNode>) {
        val (expected, root) = testCase
        val actual = isBalanced(root)
        assertEquals(expected, actual)
    }
}
