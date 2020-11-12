package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TreeNodeExtensionsTest {

    @Test
    fun `insert level order test`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr, 0)
        val actual = root.levelOrder()
        val expected = listOf(
            listOf(1),
            listOf(2, 3),
            listOf(4, 5, 6, 7)
        )
        assertEquals(expected, actual)
        assertEquals(1, root?.value)
        assertEquals(2, root?.left?.value)
        assertEquals(3, root?.right?.value)
        assertEquals(4, root?.left?.left?.value)
        assertEquals(5, root?.left?.right?.value)
        assertEquals(6, root?.right?.left?.value)
        assertEquals(7, root?.right?.right?.value)
    }

    @Test
    fun `array to tree test`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val tree = arr.toTree()
        println(tree.levelOrder().flatten())
    }
}
