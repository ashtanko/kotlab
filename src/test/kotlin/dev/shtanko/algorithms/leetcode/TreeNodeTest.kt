/*
 * Copyright 2022 Oleksii Shtanko
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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TreeNodeTest {

    @Test
    fun `get tree node height with one item`() {
        val tree = TreeNode(1)
        assertThat(tree.height()).isEqualTo(0)
    }

    @Test
    fun `get tree node height with several items`() {
        val tree = TreeNode(6).apply {
            right = TreeNode(7)
            left = TreeNode(5)
        }
        assertThat(tree.height()).isEqualTo(1)
    }

    @Test
    fun `get tree node height with many items`() {
        val tree = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
            }
        }
        assertThat(tree.height()).isEqualTo(2)
    }

    @Test
    fun `get tree node height with many items 2`() {
        val tree = TreeNode(4).apply {
            left = TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(3)
                    right = TreeNode(1)
                }
            }
            right = TreeNode(1).apply {
                right = TreeNode(6).apply {
                    left = TreeNode(5)
                }
            }
        }
        assertThat(tree.height()).isEqualTo(3)
    }

    @Test
    fun `prettyPrinted test`() {
        val tree = TreeNode(6).apply {
            right = TreeNode(7)
            left = TreeNode(5)
        }
        tree.prettyPrinted()
    }

    @Test
    fun `pretty printed test`() {
        val tree = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        val actual = tree.prettyPrinted()

        val expected = "            3           \n" +
            "      ┌─────┴─────┐     \n" +
            "      9          20     \n" +
            "               ┌──┴──┐  \n" +
            "              15     7  \n"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `pretty printed one value test`() {
        val tree = TreeNode(3)
        val actual = tree.prettyPrinted()
        val expected = "   3  \n"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `pretty printed two values test`() {
        val tree = TreeNode(3).apply {
            left = TreeNode(9)
        }
        val actual = tree.prettyPrinted()
        println(actual)
        val expected = "      3     \n" +
            "   ┌──┘     \n" +
            "   9        \n"
        assertThat(actual).isEqualTo(expected)
    }
}
