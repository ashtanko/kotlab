package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KidsWithCandiesTest {

    @Test
    fun `simple test`() {
        val candies = intArrayOf(2, 3, 5, 1, 3)
        val extraCandies = 3
        val actual = candies.kidsWithCandies(extraCandies)
        val expected = booleanArrayOf(true, true, true, false, true)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val candies = intArrayOf(4, 2, 1, 1, 2)
        val extraCandies = 1
        val actual = candies.kidsWithCandies(extraCandies)
        val expected = booleanArrayOf(true, false, false, false, false)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val candies = intArrayOf(12, 1, 12)
        val extraCandies = 10
        val actual = candies.kidsWithCandies(extraCandies)
        val expected = booleanArrayOf(true, false, true)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val candies = intArrayOf(2, 3, 5, 1, 3)
        val extraCandies = 3
        val actual = candies.kidsWithCandiesStream(extraCandies)
        val expected = booleanArrayOf(true, true, true, false, true)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 5`() {
        val candies = intArrayOf(4, 2, 1, 1, 2)
        val extraCandies = 1
        val actual = candies.kidsWithCandiesStream(extraCandies)
        val expected = booleanArrayOf(true, false, false, false, false)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 6`() {
        val candies = intArrayOf(12, 1, 12)
        val extraCandies = 10
        val actual = candies.kidsWithCandiesStream(extraCandies)
        val expected = booleanArrayOf(true, false, true)
        assertArrayEquals(expected, actual)
    }
}
