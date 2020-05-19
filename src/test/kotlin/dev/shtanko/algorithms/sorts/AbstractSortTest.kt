package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

abstract class AbstractSortTest<out T : AbstractSortStrategy>(private val strategy: T) {

    @Test
    fun `when empty array`() {
        val arr = arrayOf<Int>()
        strategy.perform(arr)
        assertArrayEquals(emptyArray(), arr)
    }

    @Test
    fun `when one element in the array`() {
        val arr = arrayOf(1)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(1), arr)
    }

    @Test
    fun `when two elements in order`() {
        val arr = arrayOf(5, 6)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(5, 6), arr)
    }

    @Test
    fun `two elements out of order`() {
        val arr = arrayOf(12, 11)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(11, 12), arr)
    }
}