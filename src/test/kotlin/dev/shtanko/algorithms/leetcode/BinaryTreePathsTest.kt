package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class BinaryTreePathsTest<out T : BinaryTreePathsStrategy>(private val strategy: T) {

    @Test
    fun `binary tree paths test`() {
        val tree = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
            left?.right = TreeNode(5)
        }
        val actual = strategy.binaryTreePaths(tree).sorted()
        val expected = listOf("1->2->5", "1->3")
        assertEquals(expected, actual)
    }

    @Test
    fun `binary tree paths test 2`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr, 0)
        val actual = strategy.binaryTreePaths(root).sorted()
        val expected = listOf("1->2->4", "1->2->5", "1->3->6", "1->3->7")
        assertEquals(expected, actual)
    }
}

internal class BinaryTreePathsRecursionTest : BinaryTreePathsTest<BinaryTreePathsRecursion>(BinaryTreePathsRecursion())

internal class BinaryTreePathsBFSQueueTest : BinaryTreePathsTest<BinaryTreePathsBFSQueue>(BinaryTreePathsBFSQueue())

internal class BinaryTreePathsBFSStackTest : BinaryTreePathsTest<BinaryTreePathsBFSStack>(BinaryTreePathsBFSStack())
