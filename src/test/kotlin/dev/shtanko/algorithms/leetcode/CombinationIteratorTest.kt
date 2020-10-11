package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal abstract class CombinationIteratorTest<out T : CombinationIterator>(private val iterator: T) {

    @Test
    fun `combination iterator test`() {
        assertEquals("ab", iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals("ac", iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals("bc", iterator.next())
        assertFalse(iterator.hasNext())
    }
}

internal class CombinationIteratorImplTest :
    CombinationIteratorTest<CombinationIteratorImpl>(CombinationIteratorImpl("abc", 2))
