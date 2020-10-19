package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDepthOfBinaryTreeTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        val actual = maxDepth(root)
        assertEquals(3, actual)
    }

    @Test
    fun `simple test iterative`() {
        val root = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        val actual = maxDepthIterative(root)
        assertEquals(3, actual)
    }
}
