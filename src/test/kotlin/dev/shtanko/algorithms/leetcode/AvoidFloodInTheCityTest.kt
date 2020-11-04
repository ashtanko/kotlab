package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class AvoidFloodInTheCityTest<out T : AvoidFloodStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider() = listOf(
            intArrayOf(1, 2, 3, 4) to intArrayOf(-1, -1, -1, -1),
            intArrayOf(1, 2, 0, 0, 2, 1) to intArrayOf(-1, -1, 2, 1, -1, -1),
            intArrayOf(1, 2, 0, 1, 2) to intArrayOf(),
            intArrayOf(69, 0, 0, 0, 69) to intArrayOf(-1, 69, 1, 1, -1),
            intArrayOf(10, 20, 20) to intArrayOf()
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `avoid flood test`(testCase: Pair<IntArray, IntArray>) {
        val expected = testCase.second
        val rains = testCase.first
        val actual = strategy.perform(rains)
        assertArrayEquals(expected, actual)
    }
}

class AvoidFloodTreeTest : AvoidFloodInTheCityTest<AvoidFloodTree>(AvoidFloodTree())
class AvoidFloodSimpleTest : AvoidFloodInTheCityTest<AvoidFloodSimple>(AvoidFloodSimple())
