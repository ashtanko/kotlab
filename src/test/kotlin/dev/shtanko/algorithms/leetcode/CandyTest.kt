package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class CandyTest<out T : CandyStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> = listOf(
            intArrayOf() to 0,
            intArrayOf(1, 0, 2) to 5,
            intArrayOf(1, 2, 2) to 4,
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `candy test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

internal class CandyBruteForceTest : CandyTest<CandyBruteForce>(CandyBruteForce())
internal class Candy2ArraysTest : CandyTest<Candy2Arrays>(Candy2Arrays())
internal class CandyArrayTest : CandyTest<CandyArray>(CandyArray())
internal class CandyMathTest : CandyTest<CandyMath>(CandyMath())
