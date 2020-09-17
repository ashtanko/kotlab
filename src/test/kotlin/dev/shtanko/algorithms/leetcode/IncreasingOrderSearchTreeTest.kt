package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class IncreasingOrderSearchTreeTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(5)
        root.left = TreeNode(3)
        root.right = TreeNode(6)
        root.left?.left = TreeNode(2)
        root.left?.right = TreeNode(4)
        root.right?.right = TreeNode(8)
        root.left?.left?.left = TreeNode(1)
        root.right?.right?.left = TreeNode(7)
        root.right?.right?.right = TreeNode(9)

        val increasingRoot = increasingBST(root)
        val actual = increasingRoot.levelOrder()

        val expected = mutableListOf<List<Int>>()
        for (i in 1 until 10) {
            expected.add(listOf(i))
        }
        assertEquals(expected, actual)
        assertNull(increasingRoot?.left)
    }
}
