package dev.shtanko.algorithms.search

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractSearchTest<out T : AbstractSearchStrategy<Int>>(private val strategy: T) {

    @Test
    fun `empty test`() {
        assertEquals(-1, strategy.perform(emptyArray(), 1))
    }

    @Test
    fun `single element test`() {
        assertEquals(0, strategy.perform(arrayOf(1), 1))
        assertEquals(-1, strategy.perform(arrayOf(1), 2))
    }

    @Test
    fun `two elements test`() {
        assertEquals(0, strategy.perform(arrayOf(4, 8), 4))
        assertEquals(1, strategy.perform(arrayOf(4, 8), 8))
        assertEquals(-1, strategy.perform(arrayOf(4, 8), 15))
    }
}