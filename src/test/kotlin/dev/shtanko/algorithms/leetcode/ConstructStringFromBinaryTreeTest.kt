package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class ConstructStringFromBinaryTreeTest<out T : ConstructStringFromBinaryTreeStrategy>(
    private val strategy: T
) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    TreeNode(1).apply {
                        left = TreeNode(2)
                        right = TreeNode(3)
                        left?.left = TreeNode(4)
                    },
                    "1(2(4))(3)"
                ),
                Arguments.of(
                    TreeNode(1).apply {
                        left = TreeNode(2)
                        left?.right = TreeNode(4)
                        right = TreeNode(3)
                    },
                    "1(2()(4))(3)"
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `construct string from binary tree test`(tree: TreeNode, expected: String) {
        val actual = strategy.perform(tree)
        assertEquals(expected, actual)
    }
}

internal class ConstructStringFromBinaryTreeRecursionTest :
    ConstructStringFromBinaryTreeTest<ConstructStringFromBinaryTreeRecursion>(ConstructStringFromBinaryTreeRecursion())

internal class ConstructStringFromBinaryTreeStackTest :
    ConstructStringFromBinaryTreeTest<ConstructStringFromBinaryTreeStack>(ConstructStringFromBinaryTreeStack())
