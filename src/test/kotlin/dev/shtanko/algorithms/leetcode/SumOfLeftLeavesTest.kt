package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class SumOfLeftLeavesTest<out T : SumOfLeftLeavesStrategy>(val strategy: T) {

    @Test
    fun `simple test`() {
        val tree = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        val expected = 24
        val actual = strategy.perform(tree)
        assertEquals(expected, actual)
    }
}

internal class SumOfLeftLeavesIterativeTest : SumOfLeftLeavesTest<SumOfLeftLeavesIterative>(SumOfLeftLeavesIterative())

internal class SumOfLeftLeavesRecursiveTest : SumOfLeftLeavesTest<SumOfLeftLeavesRecursive>(SumOfLeftLeavesRecursive())

internal class SumOfLeftLeavesBSFTest : SumOfLeftLeavesTest<SumOfLeftLeavesBSF>(SumOfLeftLeavesBSF())
