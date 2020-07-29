package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeLevelOrderTraversal2 {

    @Test
    fun `simple test`() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)

        val actual = root.levelOrderBottom()
        val expected = listOf(
            listOf(15, 7),
            listOf(9, 20),
            listOf(3)
        )
        assertEquals(expected, actual)
    }
}
