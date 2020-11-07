package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class JewelsStonesTest<out T : NumJewelsInStonesStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Int>> = listOf(
            "aA" to "aAAbbbb" to 3,
            "z" to "ZZ" to 0
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `jewels stones test`(testCase: Pair<Pair<String, String>, Int>) {
        val actual = strategy.perform(testCase.first.first, testCase.first.second)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

class NumJewelsInStonesMapTest : JewelsStonesTest<NumJewelsInStonesMap>(NumJewelsInStonesMap())
class NumJewelsInStonesRegexTest : JewelsStonesTest<NumJewelsInStonesRegex>(NumJewelsInStonesRegex())
