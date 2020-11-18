package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MostFrequentSubtreeSumTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(2)
                    right = TreeNode(-3)
                },
                intArrayOf(2, -3, 4)
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(2)
                    right = TreeNode(-5)
                },
                intArrayOf(2)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `simple test`(root: TreeNode, expected: IntArray) {
        val actual = MostFrequentSubtreeSum().perform(root)
        assertArrayEquals(expected, actual)
    }
}
