package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class AbstractMaximumProductStrategyTest<out T : AbstractMaximumProductStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, IntArray>> {
            return listOf(
                6 to intArrayOf(1, 2, 3),
                24 to intArrayOf(1, 2, 3, 4),
                60 to intArrayOf(1, 2, 3, 4, 5),
                15456 to intArrayOf(4, 8, 15, 16, 23, 42),
                60 to intArrayOf(5, 4, 3, 1),
                2561598 to intArrayOf(
                    5, 89, 1, 234, 78, 4, 9, 66, 123, 6, 9, 0
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `maximum product test`(testCase: Pair<Int, IntArray>) {
        val (expected, products) = testCase
        val actual = strategy.perform(products)
        assertEquals(expected, actual)
    }
}

internal class MaximumProductBrutForceTest :
    AbstractMaximumProductStrategyTest<MaximumProductBrutForce>(MaximumProductBrutForce())

internal class MaximumProductSortingTest :
    AbstractMaximumProductStrategyTest<MaximumProductSorting>(MaximumProductSorting())

internal class MaximumProductSingleScanTest :
    AbstractMaximumProductStrategyTest<MaximumProductSingleScan>(MaximumProductSingleScan())
