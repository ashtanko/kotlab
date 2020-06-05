package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import kotlin.random.Random

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
abstract class AbstractSortTest<out T : AbstractSortStrategy>(private val strategy: T) {

    @Test
    @Order(1)
    fun `empty test`() {
        val arr = arrayOf<Int>()
        strategy.perform(arr)
        assertArrayEquals(emptyArray(), arr)
    }

    @Test
    @Order(2)
    fun `single element test`() {
        val arr = arrayOf(4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4), arr)
    }

    @Test
    @Order(3)
    fun `two elements in order test`() {
        val arr = arrayOf(4, 8)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8), arr)
    }

    @Test
    @Order(4)
    fun `two elements out of order test`() {
        val arr = arrayOf(42, 23)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(23, 42), arr)
    }

    @Test
    @Order(5)
    fun `two elements equal test`() {
        val arr = arrayOf(4, 4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 4), arr)
    }

    @Test
    @Order(6)
    fun `reverse order test`() {
        val arr = arrayOf(42, 23, 16, 15, 8, 4)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    @Order(7)
    fun `chaotic order test`() {
        val arr = arrayOf(15, 8, 16, 4, 42, 23)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    @Order(8)
    fun `sorted elements test`() {
        val arr = arrayOf(4, 8, 15, 16, 23, 42)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    @Order(9)
    fun `negative elements in order test`() {
        val arr = arrayOf(-4, -8, -15, -16, -23, -42)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(-42, -23, -16, -15, -8, -4), arr)
    }

    @Test
    @Order(10)
    fun `random distinct elements test`() {
        val arr = Array(10_000) { 0 }
        for (i in 0 until 10_000) {
            arr[i] = Random.nextInt(10_000)
        }
        strategy.perform(arr)
        assertTrue(arr.isSorted())
    }

    @Test
    @Order(11)
    fun `partial sort test`() {
        val arr = arrayOf(4, 8, 15, 16, 42, 23)
        strategy.perform(arr)
        assertArrayEquals(arrayOf(4, 8, 15, 16, 23, 42), arr)
    }

    @Test
    @Order(12)
    fun `repeated elements test`() {
        val arr = arrayOf(1, 2, 2, 1)
        strategy.perform(arr)
        assertTrue(arr.isSorted())
    }

    @Test
    @Order(13)
    fun `strings test`() {
        val arr = arrayOf("A", "C", "B")
        strategy.perform(arr)
        val expected = arrayOf("A", "B", "C")
        assertArrayEquals(expected, arr)
    }

    @Test
    @Order(14)
    fun `sorted strings test`() {
        val arr = arrayOf("A", "B", "C", "D")
        strategy.perform(arr)
        val expected = arrayOf("A", "B", "C", "D")
        assertArrayEquals(expected, arr)
    }

    @Test
    @Order(14)
    fun `string out of order test`() {
        val arr = arrayOf("D", "C", "B", "A")
        strategy.perform(arr)
        val expected = arrayOf("A", "B", "C", "D")
        assertArrayEquals(expected, arr)
    }

    @Test
    @Order(15)
    fun `upper and lower case test`() {
        val arr = arrayOf("A", "c", "B", "e", "d", "F", "y", "G")
        strategy.perform(arr)
        println(arr.toList())
        val expected = arrayOf("A", "B", "F", "G", "c", "d", "e", "y")
        assertArrayEquals(expected, arr)
    }
}