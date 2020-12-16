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

internal class RecoverBinarySearchTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<TreeNode, List<Int>>> {
            return listOf(
                TreeNode(1).apply {
                    left = TreeNode(3)
                    left?.right = TreeNode(2)
                } to listOf(3, 1, 2),
                TreeNode(3).apply {
                    left = TreeNode(1)
                    right = TreeNode(4).apply {
                        left = TreeNode(2)
                    }
                } to listOf(2, 1, 4, 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `recover tree test`(testCase: Pair<TreeNode, List<Int>>) {
        val (root, expected) = testCase
        recoverTree(root)
        val actual = root.levelOrder().flatten()
        assertEquals(expected, actual)
    }
}
