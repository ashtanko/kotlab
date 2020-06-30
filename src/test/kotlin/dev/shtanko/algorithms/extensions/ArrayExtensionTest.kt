package dev.shtanko.algorithms.extensions

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ArrayExtensionTest {

    @Test
    fun `simple swap test`() {
        val arr = arrayOf(4, 8)
        arr.swap(1, 0)
        assertArrayEquals(arrayOf(8, 4), arr)
    }

    @Test
    fun `loop swap test`() {
        val arr = arrayOf(4, 8, 15, 16)
        for (i in 0 until arr.size - 1) {
            arr.swap(i, i + 1)
        }
        assertArrayEquals(arrayOf(8, 15, 16, 4), arr)
    }

    @Test
    fun `simple reverse test`() {
        val arr = arrayOf(4, 8, 15, 16, 23, 42)
        arr.reverse()
        assertArrayEquals(arrayOf(42, 23, 16, 15, 8, 4), arr)
    }

    @Test
    fun `two pointers technique reverse test`() {
        val arr = arrayOf(4, 8, 15, 16, 23, 42)
        arr.reverse2()
        assertArrayEquals(arrayOf(42, 23, 16, 15, 8, 4), arr)
    }

    @Test
    fun `flip test`() {
        val arr = arrayOf(4, 8, 15, 16, 23, 42)
        arr.flip(0, arr.size - 1)
        val expected = arrayOf(42, 23, 16, 15, 8, 4)
        assertArrayEquals(expected, arr)
    }

    @Test
    fun `char swap test`() {
        val arr = charArrayOf('A', 'B')
        arr.swap(1, 0)
        assertArrayEquals(charArrayOf('B', 'A'), arr)
    }

    @Test
    fun `int array swap test`() {
        val arr = intArrayOf(4, 8)
        arr.swap(1, 0)
        assertArrayEquals(intArrayOf(8, 4), arr)
    }
}
