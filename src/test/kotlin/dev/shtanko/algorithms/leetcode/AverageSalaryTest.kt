package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AverageSalaryTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(4000, 3000, 1000, 2000)
        val expected = 2500.00000
        val actual = arr.averageSalary()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1000, 2000, 3000)
        val expected = 2000.00000
        val actual = arr.averageSalary()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(6000, 5000, 4000, 3000, 2000, 1000)
        val expected = 3500.00000
        val actual = arr.averageSalary()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(8000, 9000, 2000, 3000, 6000, 1000)
        val expected = 4750.00000
        val actual = arr.averageSalary()
        println(actual)
        assertEquals(expected, actual)
    }
}
