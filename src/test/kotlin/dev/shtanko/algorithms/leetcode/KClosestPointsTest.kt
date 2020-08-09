package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KClosestPointsTest {

    @Test
    fun `simple test`() {
        val points = arrayOf(
            intArrayOf(1, 3), intArrayOf(-2, 2)
        )
        val k = 1
        val kPoints = points to k
        val kClosest = kPoints.kClosest2()
        assertArrayEquals(arrayOf(intArrayOf(-2, 2)), kClosest)
    }

    @Test
    fun `simple test 2`() {
        val points = arrayOf(
            intArrayOf(3, 3),
            intArrayOf(5, -1),
            intArrayOf(-2, 4)
        )
        val k = 2
        val kPoints = points to k
        val kClosest = kPoints.kClosest2()
        assertArrayEquals(arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4)), kClosest)
    }

    @Test
    fun `simple test 3`() {
        val points = arrayOf(
            intArrayOf(1, 3), intArrayOf(-2, 2)
        )
        val k = 1
        val kPoints = points to k
        val kClosest = kPoints.kClosest()
        assertArrayEquals(arrayOf(intArrayOf(-2, 2)), kClosest)
    }

    @Test
    fun `simple test 4`() {
        val points = arrayOf(
            intArrayOf(3, 3),
            intArrayOf(5, -1),
            intArrayOf(-2, 4)
        )
        val k = 2
        val kPoints = points to k
        val kClosest = kPoints.kClosest()
        assertArrayEquals(arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4)), kClosest)
    }
}
