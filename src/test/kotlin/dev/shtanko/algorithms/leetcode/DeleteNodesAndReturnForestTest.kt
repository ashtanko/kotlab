package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DeleteNodesAndReturnForestTest {

    @Test
    internal fun `delete nodes and return forest test`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr, 0)
        val toDelete = intArrayOf(3, 5)

        val actual = delNodes(root, toDelete).map { treeNode ->
            treeNode.levelOrder()
        }
        val expected = listOf(
            listOf(
                listOf(1),
                listOf(2),
                listOf(4)
            ),
            listOf(listOf(6)),
            listOf(listOf(7))
        )
        assertEquals(expected, actual)
    }
}
