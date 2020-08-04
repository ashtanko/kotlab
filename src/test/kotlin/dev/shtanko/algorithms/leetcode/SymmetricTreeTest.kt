package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SymmetricTreeTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left?.left = TreeNode(3)
        root.left?.right = TreeNode(4)
        root.right?.left = TreeNode(4)
        root.right?.right = TreeNode(3)
        assertTrue(root.isSymmetric())
    }

    @Test
    fun `simple test 2`() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left?.right = TreeNode(3)
        root.right?.right = TreeNode(3)
        assertFalse(root.isSymmetric())
    }
}
