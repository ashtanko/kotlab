package dev.shtanko.patterns.behavioral.iterator.bst

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BstIteratorTest {

    private lateinit var nonEmptyRoot: TreeNode<Int>
    private var emptyRoot: TreeNode<Int>? = null

    @BeforeAll
    fun createTrees() {
        nonEmptyRoot = TreeNode(5)
        nonEmptyRoot.insert(3)
        nonEmptyRoot.insert(7)
        nonEmptyRoot.insert(1)
        nonEmptyRoot.insert(4)
        nonEmptyRoot.insert(6)

        emptyRoot = null
    }

    @Test
    fun `next for empty tree test`() {
        val bstIterator = BstIterator(emptyRoot)
        assertThrows(
            NoSuchElementException::class.java,
            { bstIterator.next() },
            "next() should throw an IllegalStateException if hasNext() is false."
        )
    }

    @Test
    fun `next over entire populated tree test`() {
        val bstIterator = BstIterator(nonEmptyRoot)
        assertEquals(Integer.valueOf(1), bstIterator.next()?.value, "First Node is 1.")
        assertEquals(Integer.valueOf(3), bstIterator.next()?.value, "Second Node is 3.")
        assertEquals(Integer.valueOf(4), bstIterator.next()?.value, "Third Node is 4.")
        assertEquals(Integer.valueOf(5), bstIterator.next()?.value, "Fourth Node is 5.")
        assertEquals(Integer.valueOf(6), bstIterator.next()?.value, "Fifth Node is 6.")
        assertEquals(Integer.valueOf(7), bstIterator.next()?.value, "Sixth Node is 7.")
    }

    @Test
    fun `has next for empty tree test`() {
        val bstIterator = BstIterator(emptyRoot)
        assertFalse(bstIterator.hasNext(), "hasNext() should return false for empty tree.")
    }

    @Test
    fun `has next for populated tree test`() {
        val bstIterator = BstIterator(nonEmptyRoot)
        assertTrue(bstIterator.hasNext(), "hasNext() should return true for populated tree.")
    }

    @Test
    fun `next and has next over entire populated tree test`() {
        val bstIterator = BstIterator(nonEmptyRoot)
        assertTrue(bstIterator.hasNext(), "Iterator hasNext() should be true.")
        assertEquals(Integer.valueOf(1), bstIterator.next()?.value, "First Node is 1.")
        assertTrue(bstIterator.hasNext(), "Iterator hasNext() should be true.")
        assertEquals(Integer.valueOf(3), bstIterator.next()?.value, "Second Node is 3.")
        assertTrue(bstIterator.hasNext(), "Iterator hasNext() should be true.")
        assertEquals(Integer.valueOf(4), bstIterator.next()?.value, "Third Node is 4.")
        assertTrue(bstIterator.hasNext(), "Iterator hasNext() should be true.")
        assertEquals(Integer.valueOf(5), bstIterator.next()?.value, "Fourth Node is 5.")
        assertTrue(bstIterator.hasNext(), "Iterator hasNext() should be true.")
        assertEquals(Integer.valueOf(6), bstIterator.next()?.value, "Fifth Node is 6.")
        assertTrue(bstIterator.hasNext(), "Iterator hasNext() should be true.")
        assertEquals(Integer.valueOf(7), bstIterator.next()?.value, "Sixth Node is 7.")
        assertFalse(bstIterator.hasNext(), "Iterator hasNext() should be false, end of tree.")
    }
}
