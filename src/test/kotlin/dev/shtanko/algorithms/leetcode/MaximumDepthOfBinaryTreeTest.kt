package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class MaximumDepthOfBinaryTreeTest<out T : MaxDepthStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<TreeNode, Int>> {
            return listOf(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                } to 3
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `maximum depth of binary tree test`(testCase: Pair<TreeNode, Int>) {
        val root = testCase.first
        val expected = testCase.second
        val actual = strategy.perform(root)
        assertEquals(expected, actual)
    }
}

class MaxDepthRecursiveTest : MaximumDepthOfBinaryTreeTest<MaxDepthRecursive>(MaxDepthRecursive())
class MaxDepthIterativeTest : MaximumDepthOfBinaryTreeTest<MaxDepthIterative>(MaxDepthIterative())
