package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class TrimBinarySearchTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Triple<TreeNode, Int, Int>, List<List<Int>>>> {
            return listOf(
                Triple(
                    TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(2)
                    },
                    1,
                    2
                ) to listOf(
                    listOf(1),
                    listOf(2)
                ),
                Triple(
                    TreeNode(3).apply {
                        left = TreeNode(0).apply {
                            right = TreeNode(2).apply {
                                left = TreeNode(1)
                            }
                        }
                        right = TreeNode(4)
                    },
                    1,
                    3
                ) to listOf(
                    listOf(3),
                    listOf(2),
                    listOf(1)
                ),
                Triple(
                    TreeNode(1),
                    1,
                    2
                ) to listOf(
                    listOf(1)
                ),
                Triple(
                    TreeNode(1).apply {
                        right = TreeNode(2)
                    },
                    1,
                    3
                ) to listOf(
                    listOf(1),
                    listOf(2)
                ),
                Triple(
                    TreeNode(1).apply {
                        right = TreeNode(2)
                    },
                    2,
                    4
                ) to listOf(
                    listOf(2)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `trim BST test`(testCase: Pair<Triple<TreeNode, Int, Int>, List<List<Int>>>) {
        val (data, expected) = testCase
        val (root, low, high) = data
        val actual = trimBST(root, low, high).levelOrder()
        assertEquals(expected, actual)
    }
}
