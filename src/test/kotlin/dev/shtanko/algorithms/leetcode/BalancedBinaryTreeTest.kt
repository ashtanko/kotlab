package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BalancedBinaryTreeTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)
        assertTrue(isBalanced(root))
    }

    @Test
    fun `simple test 2`() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left?.left = TreeNode(3)
        root.left?.left?.left = TreeNode(4)
        root.left?.right = TreeNode(3)
        root.left?.left?.right = TreeNode(4)
        assertFalse(isBalanced(root))
    }
}
