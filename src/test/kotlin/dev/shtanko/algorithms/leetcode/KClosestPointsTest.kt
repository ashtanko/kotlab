package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class KClosestPointsTest<out T : KClosestPointsStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Array<IntArray>, Int>, Array<IntArray>>> = listOf(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(-2, 2)
            ) to 1 to arrayOf(intArrayOf(-2, 2)),
            arrayOf(
                intArrayOf(3, 3),
                intArrayOf(5, -1),
                intArrayOf(-2, 4)
            ) to 2 to arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4)),
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `K closest points test`(testCase: Pair<Pair<Array<IntArray>, Int>, Array<IntArray>>) {
        val (data, expected) = testCase
        val (points, k) = data
        val actual = strategy.perform(points, k)
        assertArrayEquals(expected, actual)
    }
}

internal class KClosestPointsQueueTest : KClosestPointsTest<KClosestPointsQueue>(KClosestPointsQueue())
internal class KClosestPointsSortTest : KClosestPointsTest<KClosestPointsSort>(KClosestPointsSort())
