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

internal class LeafSimilarTreesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<TreeNode, TreeNode>, Boolean>> {
            return listOf(
                TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(6)
                        right = TreeNode(2)
                        right?.left = TreeNode(7)
                        right?.right = TreeNode(4)
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(9)
                        right = TreeNode(8)
                    }
                } to TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(6)
                        right = TreeNode(7)
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(4)
                        right = TreeNode(2).apply {
                            right = TreeNode(8)
                            left = TreeNode(9)
                        }
                    }
                } to true,
                TreeNode(1) to TreeNode(1) to true,
                TreeNode(2) to TreeNode(2) to true,
                TreeNode(1).apply {
                    left = TreeNode(2)
                } to TreeNode(2).apply {
                    left = TreeNode(2)
                } to true,
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                } to TreeNode(1).apply {
                    left = TreeNode(3)
                    right = TreeNode(2)
                } to false,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `leaf similar trees test`(testCase: Pair<Pair<TreeNode, TreeNode>, Boolean>) {
        val (data, expected) = testCase
        val (root1, root2) = data
        val actual = leafSimilar(root1, root2)
        assertEquals(expected, actual)
    }
}
