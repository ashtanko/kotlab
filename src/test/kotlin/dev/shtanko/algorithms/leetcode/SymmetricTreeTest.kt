package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class SymmetricTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<TreeNode, Boolean>> {
            return listOf(
                symmetricTree to true,
                asymmetricTree to false
            )
        }

        private val symmetricTree = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
                right = TreeNode(4)
            }
            right = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(3)
            }
        }

        private val asymmetricTree = TreeNode(1).apply {
            left = TreeNode(2).apply {
                right = TreeNode(3)
            }
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is symmetric tree test`(testCase: Pair<TreeNode, Boolean>) {
        val (root, expected) = testCase
        val actual = root.isSymmetric()
        assertEquals(expected, actual)
    }
}
