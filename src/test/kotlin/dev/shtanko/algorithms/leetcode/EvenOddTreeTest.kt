package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class EvenOddTreeTest<out T : EvenOddTreeStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider(): Stream<Arguments?> = Stream.of(
            Arguments.of(
                TreeNode(1),
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(12)
                            right = TreeNode(8)
                        }
                    }
                    right = TreeNode(4).apply {
                        left = TreeNode(7).apply {
                            left = TreeNode(6)
                        }
                        right = TreeNode(9).apply {
                            right = TreeNode(2)
                        }
                    }
                },
                true
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(3)
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(7)
                    }
                },
                false
            ),
            Arguments.of(
                intArrayOf(11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2, 17).toTree(),
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `even odd tree test`(root: TreeNode, expected: Boolean) {
        val actual = strategy.perform(root)
        assertEquals(expected, actual)
    }
}

class EvenOddTreeBSFTest : EvenOddTreeTest<EvenOddTreeBSF>(EvenOddTreeBSF())
