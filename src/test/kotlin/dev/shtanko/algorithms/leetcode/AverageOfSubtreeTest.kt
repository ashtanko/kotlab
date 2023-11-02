package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.AverageOfSubtreeStrategy.DFS
import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class AverageOfSubtreeTest<out T : AverageOfSubtree>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(8).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                    right = TreeNode(5).apply {
                        right = TreeNode(6)
                    }
                },
                5,
            ),
            Arguments.of(
                TreeNode(1),
                1,
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `average of subtree test`(root: TreeNode?, expected: Int) {
        val actual = strategy(root)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class AverageOfSubtreeDFSTest : AverageOfSubtreeTest<AverageOfSubtree>(DFS)
