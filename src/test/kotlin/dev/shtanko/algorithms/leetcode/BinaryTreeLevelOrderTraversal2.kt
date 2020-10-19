package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeLevelOrderTraversal2 {

    @Test
    fun `simple test`() {
        val root = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20)
            right?.apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }

        val actual = root.levelOrderBottom()
        val expected = listOf(
            listOf(15, 7),
            listOf(9, 20),
            listOf(3)
        )
        assertEquals(expected, actual)
    }
}
