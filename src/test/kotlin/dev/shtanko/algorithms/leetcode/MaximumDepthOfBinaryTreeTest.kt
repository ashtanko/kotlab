package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDepthOfBinaryTreeTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)
        val actual = maxDepth(root)
        assertEquals(3, actual)
    }

    @Test
    fun `simple test iterative`() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)
        val actual = maxDepthIterative(root)
        assertEquals(3, actual)
    }
}
