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

internal class SymmetricTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<TreeNode, Boolean>> {
            return listOf(
                TreeNode(2) to true,
                TreeNode(2).apply {
                    left = TreeNode(1)
                } to false,
                TreeNode(5).apply {
                    right = TreeNode(6)
                } to false,
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(2)
                } to true,
                symmetricTree to true,
                asymmetricTree to false
            )
        }

        private val symmetricTree = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
                right = TreeNode(4)
            }
            right = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(3)
            }
        }

        private val asymmetricTree = TreeNode(1).apply {
            left = TreeNode(2).apply {
                right = TreeNode(3)
            }
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is symmetric tree test`(testCase: Pair<TreeNode, Boolean>) {
        val (root, expected) = testCase
        val actual = root.isSymmetric()
        assertEquals(expected, actual)
    }
}
