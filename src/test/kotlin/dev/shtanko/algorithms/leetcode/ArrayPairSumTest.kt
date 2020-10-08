package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class ArrayPairSumTest<out T : PairSumStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, IntArray>> {
            return listOf(
                4 to intArrayOf(1, 4, 3, 2),
                0 to intArrayOf(2, 1, 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `simple test`() {
        val arr = intArrayOf(1, 4, 3, 2)
        assertEquals(4, strategy.perform(arr))
    }
}

class PairSumSort1Test : ArrayPairSumTest<PairSumSort1>(PairSumSort1())

class PairSumSort2Test : ArrayPairSumTest<PairSumSort2>(PairSumSort2())

class PairSumSort3Test : ArrayPairSumTest<PairSumSort3>(PairSumSort3())

class PairSumOddTest : ArrayPairSumTest<PairSumOdd>(PairSumOdd())
