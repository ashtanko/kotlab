package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RangeSumBSTTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(10, 5, 15, 3, 7, 18)
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr)
        assertEquals(32, rangeSumBST(root, 7, 15))
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(4, 8, 15, 16, 23, 42)
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr)
        assertEquals(15, rangeSumBST(root, 8, 23))
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(10, 5, 15, 3, 7, 18)
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr)
        assertEquals(32, rangeSumBSTRecursive(root, 7, 15))
    }
}
