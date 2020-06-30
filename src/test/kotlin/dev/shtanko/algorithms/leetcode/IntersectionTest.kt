package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

abstract class AbstractIntersectionTest<out T : IntersectionStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val pair = intArrayOf(1, 2, 2, 1) to intArrayOf(2, 2)
        assertArrayEquals(intArrayOf(2), strategy.perform(pair))
    }

    @Test
    fun `simple test 2`() {
        val pair = intArrayOf(4, 9, 5) to intArrayOf(9, 4, 9, 8, 4)
        assertArrayEquals(intArrayOf(4, 9), strategy.perform(pair))
    }

    @Test
    fun `simple test 3`() {
        val pair = intArrayOf(4, 8) to intArrayOf(15, 16, 23, 4)
        assertArrayEquals(intArrayOf(4), strategy.perform(pair))
    }

    @Test
    fun `simple test 4`() {
        val pair = intArrayOf(4, 8) to intArrayOf(15, 16, 23, 42)
        assertArrayEquals(intArrayOf(), strategy.perform(pair))
    }
}

class IntersectionTwoSetsTest : AbstractIntersectionTest<IntersectionTwoSets>(IntersectionTwoSets())

class IntersectionTwoPointersTest : AbstractIntersectionTest<IntersectionTwoPointers>(IntersectionTwoPointers())

class IntersectionBinarySearchTest : AbstractIntersectionTest<IntersectionBinarySearch>(IntersectionBinarySearch())
