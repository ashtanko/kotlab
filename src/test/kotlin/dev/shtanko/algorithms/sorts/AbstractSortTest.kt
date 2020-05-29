package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.random.Random

abstract class AbstractSortTest<out T : AbstractSortStrategy>(private val strategy: T) {

    @Test
    fun `empty test`() {
        val arr = arrayOf<Int>()
        strategy.perform(arr)
        assertArrayEquals(emptyArray(), arr)
    }

    @Test
    fun `single element test`() {
        val arr = arrayOf(4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4), arr)
    }

    @Test
    fun `two elements in order test`() {
        val arr = arrayOf(4, 8)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8), arr)
    }

    @Test
    fun `two elements out of order test`() {
        val arr = arrayOf(42, 23)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(23, 42), arr)
    }

    @Test
    fun `two elements equal test`() {
        val arr = arrayOf(4, 4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 4), arr)
    }

    @Test
    fun `reverse order test`() {
        val arr = arrayOf(42, 23, 16, 15, 8, 4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    fun `chaotic order test`() {
        val arr = arrayOf(15, 8, 16, 4, 42, 23)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    fun `sorted elements test`() {
        val arr = arrayOf(4, 8, 15, 16, 23, 42)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    fun `negative elements in order test`() {
        val arr = arrayOf(-4, -8, -15, -16, -23, -42)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(-42, -23, -16, -15, -8, -4), arr)
    }

    @Test
    fun `random distinct elements test`() {
        val arr = Array(10_000) { 0 }
        for (i in 0 until 10_000) {
            arr[i] = Random.nextInt(10_000)
        }
        strategy.perform(arr)
        assertTrue(arr.isSorted())
    }

    @Test
    fun `partial sort test`() {
        val arr = arrayOf(4, 8, 15, 16, 42, 23)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    fun `repeated elements test`() {
        val arr = arrayOf(1, 2, 2, 1)
        strategy.perform(arr)
        assertTrue(arr.isSorted())
    }
}