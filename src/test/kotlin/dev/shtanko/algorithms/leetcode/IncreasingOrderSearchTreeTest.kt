package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class IncreasingOrderSearchTreeTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(5).apply {
            left = TreeNode(3)
            right = TreeNode(6)
            left?.apply {
                left = TreeNode(2)
                left?.left = TreeNode(1)
                right = TreeNode(4)
            }
            right?.apply {
                right = TreeNode(8)
                right?.left = TreeNode(7)
                right?.right = TreeNode(9)
            }
        }

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
