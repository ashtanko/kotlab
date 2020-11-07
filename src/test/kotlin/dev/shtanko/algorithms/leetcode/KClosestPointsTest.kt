package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class KClosestPointsTest<out T : KClosestPointsStrategy>(private val strategy: T) {

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
            ) to 2 to arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4))
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `kClosest test`(testCase: Pair<Pair<Array<IntArray>, Int>, Array<IntArray>>) {
        val points = testCase.first.first
        val k = testCase.first.second
        val actual = strategy.perform(points, k)
        val expected = testCase.second
        assertArrayEquals(expected, actual)
    }
}

class KClosestPointsQueueTest : KClosestPointsTest<KClosestPointsQueue>(KClosestPointsQueue())
class KClosestPointsSortTest : KClosestPointsTest<KClosestPointsSort>(KClosestPointsSort())
