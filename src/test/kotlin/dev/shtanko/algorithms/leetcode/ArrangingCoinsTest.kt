package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class ArrangingCoinsTest<out T : ArrangingCoinsStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, Int>> {
            return listOf(
                5 to 2,
                8 to 3
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `simple test`(testCase: Pair<Int, Int>) {
        val coins = testCase.first
        val expected = testCase.second
        val actual = strategy.arrangeCoins(coins)
        assertEquals(expected, actual)
    }
}

class ArrangingCoinsMathTest : ArrangingCoinsTest<ArrangingCoinsMath>(ArrangingCoinsMath())

class ArrangingCoinsBSTest : ArrangingCoinsTest<ArrangingCoinsBS>(ArrangingCoinsBS())
