package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class SuperUglyNumberTest<out T : SuperUglyNumberStrategy>(private val strategy: T) {
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
    fun `super ugly number test`(testCase: Pair<Pair<Int, IntArray>, Int>) {
        val n = testCase.first.first
        val primes = testCase.first.second
        val expected = testCase.second
        val actual = strategy.perform(n, primes)
        assertEquals(expected, actual)
    }
}

class SuperUglyNumberCommonTest : SuperUglyNumberTest<SuperUglyNumberCommon>(SuperUglyNumberCommon())

class SuperUglyNumberRedundantMultiplicationTest :
    SuperUglyNumberTest<SuperUglyNumberRedundantMultiplication>(SuperUglyNumberRedundantMultiplication())

class SuperUglyNumberHeapTest :
    SuperUglyNumberTest<SuperUglyNumberHeap>(SuperUglyNumberHeap())
