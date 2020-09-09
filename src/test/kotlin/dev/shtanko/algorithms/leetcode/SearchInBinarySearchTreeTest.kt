package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchInBinarySearchTreeTest {

    @Test
    fun `simple test`() {
        val tree = TreeNode(4)
        tree.left = TreeNode(2)
        tree.right = TreeNode(7)
        tree.left?.left = TreeNode(1)
        tree.left?.right = TreeNode(3)
        val actual = searchBST(tree, 2)
        val list = mutableListOf<Int?>()
        list.add(actual?.value)
        list.add(actual?.left?.value)
        list.add(actual?.right?.value)
        val expected = listOf(2, 1, 3)
        assertEquals(expected, list)
    }
}
