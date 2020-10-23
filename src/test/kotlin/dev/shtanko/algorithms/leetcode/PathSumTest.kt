package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class PathSumTest<out T : PathSumStrategy>(private val strategy: T) {

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
    fun `simple test`(testCase: Pair<Pair<TreeNode, Int>, Boolean>) {
        val tree = testCase.first.first
        val sum = testCase.first.second
        val actual = strategy.hasPathSum(tree, sum)
        if (testCase.second) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}

class PathSumRecursiveTest : PathSumTest<PathSumRecursive>(PathSumRecursive())

class PathSumStackTest : PathSumTest<PathSumStack>(PathSumStack())
