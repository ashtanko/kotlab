package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class BalancedBinaryTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, TreeNode>> {
            return listOf(
                true to TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20)
                    right?.apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                false to TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(2)
                    left?.apply {
                        left = TreeNode(3)
                        right = TreeNode(3)
                        left?.apply {
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
        val root = testCase.second
        val actual = isBalanced(root)
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
