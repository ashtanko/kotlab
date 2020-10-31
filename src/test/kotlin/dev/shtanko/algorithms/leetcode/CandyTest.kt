package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class CandyTest<out T : CandyStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> = listOf(
            intArrayOf(1, 0, 2) to 5,
            intArrayOf(1, 2, 2) to 4
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `candy test`(testCase: Pair<IntArray, Int>) {
        val expected = testCase.second
        val actual = strategy.perform(testCase.first)
        assertEquals(expected, actual)
    }
}

class CandyBruteForceTest : CandyTest<CandyBruteForce>(CandyBruteForce())
class Candy2ArraysTest : CandyTest<Candy2Arrays>(Candy2Arrays())
class CandyArrayTest : CandyTest<CandyArray>(CandyArray())
class CandyMathTest : CandyTest<CandyMath>(CandyMath())
