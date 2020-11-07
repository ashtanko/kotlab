package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class AbstractIntersectionTest<out T : IntersectionStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, IntArray>> = listOf(
            intArrayOf(1, 2, 2, 1) to intArrayOf(2, 2) to intArrayOf(2),
            intArrayOf(4, 9, 5) to intArrayOf(9, 4, 9, 8, 4) to intArrayOf(4, 9),
            intArrayOf(4, 8) to intArrayOf(15, 16, 23, 4) to intArrayOf(4),
            intArrayOf(4, 8) to intArrayOf(15, 16, 23, 42) to intArrayOf()
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `intersection test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val pair = testCase.first
        val expected = testCase.second
        val actual = strategy.perform(pair)
        assertArrayEquals(expected, actual)
    }
}

class IntersectionTwoSetsTest : AbstractIntersectionTest<IntersectionTwoSets>(IntersectionTwoSets())

class IntersectionTwoPointersTest : AbstractIntersectionTest<IntersectionTwoPointers>(IntersectionTwoPointers())

class IntersectionBinarySearchTest : AbstractIntersectionTest<IntersectionBinarySearch>(IntersectionBinarySearch())
