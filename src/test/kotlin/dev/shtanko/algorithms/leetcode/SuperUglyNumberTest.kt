package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class SuperUglyNumberTest<out T : SuperUglyNumberStrategy>(private val strategy: T) {
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, IntArray>, Int>> {
            return listOf(
                12 to intArrayOf(2, 7, 13, 19) to 32,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `super ugly number test`(testCase: Pair<Pair<Int, IntArray>, Int>) {
        val (data, expected) = testCase
        val (n, primes) = data
        val actual = strategy.perform(n, primes)
        assertEquals(expected, actual)
    }
}

internal class SuperUglyNumberCommonTest : SuperUglyNumberTest<SuperUglyNumberCommon>(SuperUglyNumberCommon())

internal class SuperUglyNumberRedundantMultiplicationTest :
    SuperUglyNumberTest<SuperUglyNumberRedundantMultiplication>(SuperUglyNumberRedundantMultiplication())

internal class SuperUglyNumberHeapTest :
    SuperUglyNumberTest<SuperUglyNumberHeap>(SuperUglyNumberHeap())
