package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal abstract class AverageOfLevelsInBinaryTreeStrategyTest<out T : AverageOfLevelsInBinaryTreeStrategy>(
    private val strategy: T
) {

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
                    doubleArrayOf(3.0, 14.5, 11.0)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    fun `average of levels in binary tree test`(tree: TreeNode, expected: DoubleArray) {
        val actual = strategy.perform(tree)
        assertArrayEquals(expected, actual)
    }
}

internal class AverageOfLevelsInBinaryTreeDFSTest :
    AverageOfLevelsInBinaryTreeStrategyTest<AverageOfLevelsInBinaryTreeDFS>(
        AverageOfLevelsInBinaryTreeDFS()
    )

internal class AverageOfLevelsInBinaryTreeBFSTest :
    AverageOfLevelsInBinaryTreeStrategyTest<AverageOfLevelsInBinaryTreeBFS>(
        AverageOfLevelsInBinaryTreeBFS()
    )
