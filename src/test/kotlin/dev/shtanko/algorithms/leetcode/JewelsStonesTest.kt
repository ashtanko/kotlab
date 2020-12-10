package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class JewelsStonesTest<out T : NumJewelsInStonesStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Int>> = listOf(
            "aA" to "aAAbbbb" to 3,
            "z" to "ZZ" to 0,
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `jewels stones test`(testCase: Pair<Pair<String, String>, Int>) {
        val (data, expected) = testCase
        val (a, b) = data
        val actual = strategy.perform(a, b)
        assertEquals(expected, actual)
    }
}

internal class NumJewelsInStonesMapTest : JewelsStonesTest<NumJewelsInStonesMap>(NumJewelsInStonesMap())
internal class NumJewelsInStonesRegexTest : JewelsStonesTest<NumJewelsInStonesRegex>(NumJewelsInStonesRegex())
