package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class PathSumTest<out T : PathSumStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Pair<TreeNode, Int>, Boolean>> {
            return listOf(
                TreeNode(5).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(11).apply {
                            left = TreeNode(7)
                            right = TreeNode(2)
                        }
                    }
                    right = TreeNode(8).apply {
                        left = TreeNode(13)
                        right = TreeNode(4).apply {
                            right = TreeNode(1)
                        }
                    }
                } to 22 to true
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `path sum test`(testCase: Pair<Pair<TreeNode, Int>, Boolean>) {
        val (data, expected) = testCase
        val (tree, sum) = data
        val actual = strategy.hasPathSum(tree, sum)
        assertEquals(expected, actual)
    }
}

internal class PathSumRecursiveTest : PathSumTest<PathSumRecursive>(PathSumRecursive())

internal class PathSumStackTest : PathSumTest<PathSumStack>(PathSumStack())
