package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal abstract class AverageOfLevelsInBinaryTreeStrategyTest<out T : AverageOfLevelsInBinaryTreeStrategy>(
    private val strategy: T
) {

    @Test
    fun `simple test`() {
        val tree = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20)
            right?.apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        val actual = strategy.perform(tree)
        val expected = doubleArrayOf(3.0, 14.5, 11.0)
        assertArrayEquals(expected, actual)
    }
}

internal class AverageOfLevelsInBinaryTreeDFSTest :
    AverageOfLevelsInBinaryTreeStrategyTest<AverageOfLevelsInBinaryTreeDFS>(
        AverageOfLevelsInBinaryTreeDFS()
    )

internal class AverageOfLevelsInBinaryTreeBFSTest :
    AverageOfLevelsInBinaryTreeStrategyTest<AverageOfLevelsInBinaryTreeBFS>(
        AverageOfLevelsInBinaryTreeBFS()
    )
