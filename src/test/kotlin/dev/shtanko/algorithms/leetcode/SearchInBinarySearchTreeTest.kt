package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SearchInBinarySearchTreeTest {

    @Test
    internal fun `search in binary search tree test`() {
        val tree = TreeNode(4).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
            right = TreeNode(7)
        }
        val actual = searchBST(tree, 2)
        val list = mutableListOf<Int?>()
        list.add(actual?.value)
        list.add(actual?.left?.value)
        list.add(actual?.right?.value)
        val expected = listOf(2, 1, 3)
        assertEquals(expected, list)
    }
}
