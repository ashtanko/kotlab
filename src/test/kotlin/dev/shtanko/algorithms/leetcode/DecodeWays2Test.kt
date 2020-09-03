package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractDecodeWays2StrategyTest<out T : DecodeWays2Strategy>(private val strategy: DecodeWays2Strategy) {

    @Test
    fun `simple test`() {
        assertEquals(9, strategy.perform("*"))
    }

    @Test
    fun `simple test 2`() {
        assertEquals(18, strategy.perform("1*"))
    }
}

class DecodeWays2RecursionWithMemoizationTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2RecursionWithMemoization>(DecodeWays2RecursionWithMemoization())

class DecodeWays2DynamicProgrammingTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2DynamicProgramming>(DecodeWays2DynamicProgramming())

class DecodeWays2ConstantSpaceDynamicProgrammingTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2ConstantSpaceDynamicProgramming>(
        DecodeWays2ConstantSpaceDynamicProgramming()
    )
