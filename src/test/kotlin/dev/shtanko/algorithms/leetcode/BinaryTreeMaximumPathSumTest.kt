package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.BinaryTreeMaximumPathSum.maxPathSum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeMaximumPathSumTest {

    @Test
    fun `simple test`() {
        val tree = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }
        assertEquals(6, tree.maxPathSum())
    }

    @Test
    fun `simple test 2`() {
        val tree = TreeNode(-10).apply {
            left = TreeNode(9)
            right = TreeNode(20)
            right?.apply {
                right = TreeNode(7)
                left = TreeNode(15)
            }
        }
        assertEquals(42, tree.maxPathSum())
    }
}
