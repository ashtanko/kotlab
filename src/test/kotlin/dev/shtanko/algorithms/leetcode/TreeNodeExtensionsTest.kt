package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class TreeNodeExtensionsTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                listOf<Int>()
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
                listOf(1, 2, 3, 4, 5, 6, 7)
            )
        )
    }

    @Test
    internal fun `insert level order test`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr, 0)
        val actual = root.levelOrder()
        val expected = listOf(
            listOf(1),
            listOf(2, 3),
            listOf(4, 5, 6, 7)
        )
        assertEquals(expected, actual)
        assertEquals(1, root?.value)
        assertEquals(2, root?.left?.value)
        assertEquals(3, root?.right?.value)
        assertEquals(4, root?.left?.left?.value)
        assertEquals(5, root?.left?.right?.value)
        assertEquals(6, root?.right?.left?.value)
        assertEquals(7, root?.right?.right?.value)
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `array to tree test`(arr: IntArray, expected: List<Int>) {
        val tree = arr.toTree()
        val actual = tree.levelOrder().flatten()
        assertEquals(expected, actual)
    }
}
