package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class SuperEggDropStrategyTest<out T : SuperEggDropStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Pair<Int, Int>>> {
            return listOf(
                3 to (2 to 6),
                4 to (3 to 14)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `super egg drop test`(testCase: Pair<Int, Pair<Int, Int>>) {
        val (expected, data) = testCase
        val (eggs, floors) = data
        val actual = strategy.perform(eggs, floors)
        assertEquals(expected, actual)
    }
}

internal class SuperEggDropDPBinarySearchTest :
    SuperEggDropStrategyTest<SuperEggDropDPBinarySearch>(SuperEggDropDPBinarySearch())

internal class SuperEggDropDPOptimalityCriterionTest :
    SuperEggDropStrategyTest<SuperEggDropDPOptimalityCriterion>(SuperEggDropDPOptimalityCriterion())

internal class SuperEggDropMathematicalTest :
    SuperEggDropStrategyTest<SuperEggDropMathematical>(SuperEggDropMathematical())
