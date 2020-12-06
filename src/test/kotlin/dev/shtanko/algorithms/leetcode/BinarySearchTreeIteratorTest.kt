package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

private fun getTree(): TreeNode {
    return TreeNode(7).apply {
        left = TreeNode(3)
        right = TreeNode(15)
        right?.apply {
            left = TreeNode(9)
            right = TreeNode(20)
        }
    }
}

internal abstract class BinarySearchTreeIteratorTest<out T : BSTIterator>(private val iterator: T) {

    @Test
    internal fun `bst iterator test`() {
        assertEquals(3, iterator.next())
        assertEquals(7, iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals(9, iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals(15, iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals(20, iterator.next())
        assertFalse(iterator.hasNext())
    }
}

internal class BSTIteratorFlatteningTest :
    BinarySearchTreeIteratorTest<BSTIteratorFlattening>(BSTIteratorFlattening(getTree()))

internal class BSTIteratorControlledRecursionTest :
    BinarySearchTreeIteratorTest<BSTIteratorControlledRecursion>(BSTIteratorControlledRecursion(getTree()))
