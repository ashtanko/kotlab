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
                }
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
