package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class ConstructStringFromBinaryTreeTest<out T : ConstructStringFromBinaryTreeStrategy>(
    private val strategy: T
) {

    @Test
    fun `simple test`() {
        val tree = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
            left?.left = TreeNode(4)
        }
        val expected = "1(2(4))(3)"
        val actual = strategy.perform(tree)
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val tree = TreeNode(1).apply {
            left = TreeNode(2)
            left?.right = TreeNode(4)
            right = TreeNode(3)
        }
        val expected = "1(2()(4))(3)"
        val actual = strategy.perform(tree)
        assertEquals(expected, actual)
    }
}

internal class ConstructStringFromBinaryTreeRecursionTest :
    ConstructStringFromBinaryTreeTest<ConstructStringFromBinaryTreeRecursion>(ConstructStringFromBinaryTreeRecursion())

internal class ConstructStringFromBinaryTreeStackTest :
    ConstructStringFromBinaryTreeTest<ConstructStringFromBinaryTreeStack>(ConstructStringFromBinaryTreeStack())
