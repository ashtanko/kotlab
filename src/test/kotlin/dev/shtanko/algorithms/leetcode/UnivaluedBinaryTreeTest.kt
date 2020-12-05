package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class UnivaluedBinaryTreeStrategyTest<out T : UnivaluedBinaryTreeStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, TreeNode>> {
            return listOf(
                true to TreeNode(1).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(1)
                        right = TreeNode(1)
                    }
                    right = TreeNode(1).apply {
                        right = TreeNode(1)
                    }
                },
                false to TreeNode(2).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(5)
                        right = TreeNode(2)
                    }
                    right = TreeNode(2)
                }
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `univalued binary tree test`(testCase: Pair<Boolean, TreeNode>) {
        val (expected, tree) = testCase
        val actual = strategy.perform(tree)
        assertEquals(expected, actual)
    }
}

internal class UnivaluedBinaryTreeDFSTest :
    UnivaluedBinaryTreeStrategyTest<UnivaluedBinaryTreeDFS>(UnivaluedBinaryTreeDFS())

internal class UnivaluedBinaryTreeRecursiveTest :
    UnivaluedBinaryTreeStrategyTest<UnivaluedBinaryTreeRecursive>(UnivaluedBinaryTreeRecursive())
