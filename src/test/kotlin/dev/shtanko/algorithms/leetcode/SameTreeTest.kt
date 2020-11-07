package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SameTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<TreeNode, TreeNode>, Boolean>> {
            return listOf(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                } to TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                } to true,
                TreeNode(1).apply {
                    left = TreeNode(2)
                } to TreeNode(1).apply {
                    right = TreeNode(2)
                } to false,
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(2)
                } to TreeNode(1).apply {
                    right = TreeNode(2)
                    left = TreeNode(1)
                } to false
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `is same test test`(testCase: Pair<Pair<TreeNode, TreeNode>, Boolean>) {
        val actual = testCase.first.isSame()
        if (testCase.second) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
