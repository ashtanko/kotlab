package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SameTreeTest {

    @Test
    fun `same test`() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)
        t1.right = TreeNode(3)

        val t2 = TreeNode(1)
        t2.left = TreeNode(2)
        t2.right = TreeNode(3)

        assertTrue((t1 to t2).isSame())
    }

    @Test
    fun `not same test`() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)

        val t2 = TreeNode(1)
        t2.right = TreeNode(2)

        assertFalse((t1 to t2).isSame())
    }

    @Test
    fun `not same 2 test`() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)
        t1.right = TreeNode(2)

        val t2 = TreeNode(1)
        t2.right = TreeNode(2)
        t2.left = TreeNode(1)

        assertFalse((t1 to t2).isSame())
    }
}
