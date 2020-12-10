package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class DistributeCandiesToPeopleTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Triple<Int, Int, IntArray>> {
            return listOf(
                Triple(7, 4, intArrayOf(1, 2, 3, 1)),
                Triple(10, 3, intArrayOf(5, 2, 3)),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Triple<Int, Int, IntArray>) {
        val (candies, numOfPeople, expected) = testCase
        val actual = distributeCandies(candies, numOfPeople)
        println(actual.toList())
        assertArrayEquals(expected, actual)
    }
}
