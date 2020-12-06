package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindModeInBinarySearchTreeTest {

    companion object {

        @JvmStatic
        fun dataProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        left = TreeNode(2)
                    }
                },
                intArrayOf(2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `find mode in binary search tree test`(root: TreeNode, expected: IntArray) {
        val actual = FindModeInBinarySearchTree().perform(root)
        assertArrayEquals(actual, expected)
    }
}
