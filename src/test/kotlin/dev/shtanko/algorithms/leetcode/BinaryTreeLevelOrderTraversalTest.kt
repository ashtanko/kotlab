package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreeLevelOrderTraversalTest {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    TreeNode(3).apply {
                        left = TreeNode(9)
                        right = TreeNode(20)
                        right?.apply {
                            left = TreeNode(15)
                            right = TreeNode(7)
                        }
                    },
                    listOf(
                        listOf(3),
                        listOf(9, 20),
                        listOf(15, 7)
                    )
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `level order traversal test`(root: TreeNode, expected: List<List<Int>>) {
        val actual = root.levelOrder()
        assertEquals(expected, actual)
    }
}
