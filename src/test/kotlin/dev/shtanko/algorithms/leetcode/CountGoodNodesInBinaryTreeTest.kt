package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CountGoodNodesInBinaryTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): Stream<Arguments?> = Stream.of(
            Arguments.of(intArrayOf(3, 1, 4, 3, 1, 5).toTree(), 4),
            Arguments.of(intArrayOf(3, 3, 4, 2).toTree(), 3)
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `count good nodes in binary tree test`(tree: TreeNode, expected: Int) {
        val actual = CountGoodNodesInBinaryTree().goodNodes(tree)
        assertEquals(expected, actual)
    }
}
