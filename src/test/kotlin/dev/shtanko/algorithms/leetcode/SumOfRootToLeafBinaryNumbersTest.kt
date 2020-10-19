package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class SumOfRootToLeafBinaryNumbersTest<out T : SumOfRootToLeafBinaryNumbersStrategy>(
    private val strategy: T
) {

    @Test
    fun `simple test`() {
        val root = TreeNode(1).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
        }
        val actual = strategy.sumRootToLeaf(root)
        assertEquals(22, actual)
    }
}

internal class SumOfRootToLeafBinaryNumbersIPTTest :
    SumOfRootToLeafBinaryNumbersTest<SumOfRootToLeafBinaryNumbersIPT>(SumOfRootToLeafBinaryNumbersIPT())

internal class SumOfRootToLeafBinaryNumbersRPTTest :
    SumOfRootToLeafBinaryNumbersTest<SumOfRootToLeafBinaryNumbersRPT>(SumOfRootToLeafBinaryNumbersRPT())

internal class SumOfRootToLeafBinaryNumbersMPTTest :
    SumOfRootToLeafBinaryNumbersTest<SumOfRootToLeafBinaryNumbersMPT>(SumOfRootToLeafBinaryNumbersMPT())
