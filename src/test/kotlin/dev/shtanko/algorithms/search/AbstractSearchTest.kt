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
        val arr = arrayOf(1)
        assertEquals(0, strategy.perform(arr, 1))
        assertEquals(-1, strategy.perform(arr, 2))
    }

    @Test
    fun `two elements test`() {
        val arr = arrayOf(4, 8)
        assertEquals(0, strategy.perform(arr, 4))
        assertEquals(1, strategy.perform(arr, 8))
        assertEquals(-1, strategy.perform(arr, 15))
    }

    @Test
    fun `six elements test`() {
        val arr = arrayOf(4, 8, 15, 16, 23, 42)
        assertEquals(0, strategy.perform(arr, 4))
        assertEquals(1, strategy.perform(arr, 8))
        assertEquals(2, strategy.perform(arr, 15))
        assertEquals(3, strategy.perform(arr, 16))
        assertEquals(4, strategy.perform(arr, 23))
        assertEquals(5, strategy.perform(arr, 42))
        assertEquals(-1, strategy.perform(arr, 56))
    }
}