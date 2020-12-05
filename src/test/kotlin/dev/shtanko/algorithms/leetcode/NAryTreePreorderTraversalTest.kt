package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class NAryTreePreorderTraversalTest<out T : NAryTreePreorderTraversalStrategy>(
    private val strategy: T
) {

    @Test
    internal fun `NAry tree preorder traversal test`() {
        val root = NAryNode(1)
        val third = NAryNode(3)
        third.children = listOf(NAryNode(5), NAryNode(6))
        root.children = listOf(third, NAryNode(2), NAryNode(4))
        val actual = strategy.preorder(root)
        assertEquals(listOf(1, 3, 5, 6, 2, 4), actual)
    }

    @Test
    internal fun `NAry tree preorder traversal 2 test`() {
        val root = NAryNode(1)
        val third = NAryNode(3)
        val seventh = NAryNode(7)
        val eleventh = NAryNode(11)
        seventh.children = listOf(eleventh)
        eleventh.children = listOf(NAryNode(14))
        third.children = listOf(NAryNode(6), seventh)

        val fourth = NAryNode(4)
        val eight = NAryNode(8)
        fourth.children = listOf(eight)
        eight.children = listOf(NAryNode(12))

        val fifth = NAryNode(5)
        val ninth = NAryNode(9)
        ninth.children = listOf(NAryNode(13))
        fifth.children = listOf(ninth, NAryNode(10))

        root.children = listOf(NAryNode(2), third, fourth, fifth)
        val actual = strategy.preorder(root)
        assertEquals(listOf(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10), actual)
    }
}

internal class NAryTreePreorderTraversalIterativeTest :
    NAryTreePreorderTraversalTest<NAryTreePreorderTraversalIterative>(NAryTreePreorderTraversalIterative())

internal class NAryTreePreorderTraversalRecursiveTest :
    NAryTreePreorderTraversalTest<NAryTreePreorderTraversalRecursive>(NAryTreePreorderTraversalRecursive())
