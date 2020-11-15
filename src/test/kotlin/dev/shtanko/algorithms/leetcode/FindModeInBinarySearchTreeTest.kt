package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FindModeInBinarySearchTreeTest {

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
    fun `simple test`(root: TreeNode, expected: IntArray) {
        val actual = FindModeInBinarySearchTree().perform(root)
        assertArrayEquals(actual, expected)
    }
}
