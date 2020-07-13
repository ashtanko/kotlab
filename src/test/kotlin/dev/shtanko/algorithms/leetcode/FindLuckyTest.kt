package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class FindLuckyTest {

    @Test
    @Order(1)
    fun `simple test`() {
        val arr = intArrayOf(2, 2, 3, 4)
        assertEquals(2, arr.findLucky())
    }

    @Test
    @Order(2)
    fun `simple test 2`() {
        val arr = intArrayOf(1, 2, 2, 3, 3, 3)
        assertEquals(3, arr.findLucky())
    }

    @Test
    @Order(3)
    fun `simple test 3`() {
        val arr = intArrayOf(2, 2, 2, 3, 3)
        assertEquals(-1, arr.findLucky())
    }

    @Test
    @Order(4)
    fun `simple test 4`() {
        val arr = intArrayOf(5)
        assertEquals(-1, arr.findLucky())
    }

    @Test
    @Order(5)
    fun `simple test 5`() {
        val arr = intArrayOf(7, 7, 7, 7, 7, 7, 7)
        assertEquals(7, arr.findLucky())
    }

    @Test
    @Order(6)
    fun `simple test 6`() {
        val arr = intArrayOf(2, 2, 3, 4)
        assertEquals(2, arr.findLuckyMap())
    }

    @Test
    @Order(7)
    fun `simple test 7`() {
        val arr = intArrayOf(1, 2, 2, 3, 3, 3)
        assertEquals(3, arr.findLuckyMap())
    }

    @Test
    @Order(8)
    fun `simple test 8`() {
        val arr = intArrayOf(2, 2, 2, 3, 3)
        assertEquals(-1, arr.findLuckyMap())
    }

    @Test
    @Order(9)
    fun `simple test 9`() {
        val arr = intArrayOf(5)
        assertEquals(-1, arr.findLuckyMap())
    }

    @Test
    @Order(10)
    fun `simple test 10`() {
        val arr = intArrayOf(7, 7, 7, 7, 7, 7, 7)
        assertEquals(7, arr.findLuckyMap())
    }
}
