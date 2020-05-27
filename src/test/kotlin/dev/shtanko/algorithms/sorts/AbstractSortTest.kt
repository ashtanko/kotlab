package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.random.Random

abstract class AbstractSortTest<out T : AbstractSortStrategy>(private val strategy: T) {

    @Test
    fun `when empty array`() {
        val arr = arrayOf<Int>()
        strategy.perform(arr)
        assertArrayEquals(emptyArray(), arr)
    }

    @Test
    fun `when one element in the array`() {
        val arr = arrayOf(4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4), arr)
    }

    @Test
    fun `when two elements in order`() {
        val arr = arrayOf(4, 8)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8), arr)
    }

    @Test
    fun `when two elements out of order`() {
        val arr = arrayOf(42, 23)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(23, 42), arr)
    }

    @Test
    fun `when two elements equal`() {
        val arr = arrayOf(4, 4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 4), arr)
    }

    @Test
    fun `when reverse`() {
        val arr = arrayOf(42, 23, 16, 15, 8, 4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    fun `chaotic elements order`() {
        val arr = arrayOf(15, 8, 16, 4, 42, 23)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    fun `elements in order`() {
        val arr = arrayOf(4, 8, 15, 16, 23, 42)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    fun `negative elements in order`() {
        val arr = arrayOf(-4, -8, -15, -16, -23, -42)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(-42, -23, -16, -15, -8, -4), arr)
    }

    @Test
    fun `random elements`() {
        val arr = Array(10_000) { 0 }
        for (i in 0 until 10_000) {
            arr[i] = Random.nextInt(10_000)
        }
        strategy.perform(arr)
        assertTrue(arr.asSequence().zipWithNext { a, b -> a <= b }.all { it })
    }
}