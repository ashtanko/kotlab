package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class ArrayPairSumTest<out T : PairSumStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf() to 0,
                intArrayOf(1, 4, 3, 2) to 4
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `simple test`(data: Pair<IntArray, Int>) {
        val (arr, expected) = data
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

internal class PairSumSort1Test : ArrayPairSumTest<PairSumSort1>(PairSumSort1())

internal class PairSumSort2Test : ArrayPairSumTest<PairSumSort2>(PairSumSort2())

internal class PairSumSort3Test : ArrayPairSumTest<PairSumSort3>(PairSumSort3())

internal class PairSumOddTest : ArrayPairSumTest<PairSumOdd>(PairSumOdd())
