package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class FibonacciNumberTest<out T : FibonacciStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun numberProvider(): List<Pair<Int, Long>> = listOf(
            0 to 0L,
            1 to 1L,
            2 to 1L,
            3 to 2L,
            4 to 3L,
            5 to 5L,
            6 to 8L,
            7 to 13L,
            8 to 21L,
            9 to 34L,
            10 to 55L,
            11 to 89L,
            12 to 144L,
            13 to 233L,
            14 to 377L,
            15 to 610L,
            16 to 987L,
            17 to 1597L,
            18 to 2584L,
            19 to 4181L,
            20 to 6765L,
            21 to 10946L,
            22 to 17711L,
            23 to 28657L,
            24 to 46368L,
            25 to 75025L,
            26 to 121393L,
            27 to 196418L,
            28 to 317811L,
            29 to 514229L,
            30 to 832040L,
            31 to 1346269L,
            32 to 2178309L,
            33 to 3524578L,
            34 to 5702887L,
            35 to 9227465L,
            36 to 14930352L,
            37 to 24157817L,
            38 to 39088169L,
            39 to 63245986L,
            40 to 102334155L,
            41 to 165580141L,
            42 to 267914296L,
            43 to 433494437L,
            44 to 701408733L
        )
    }

    @ParameterizedTest
    @MethodSource("numberProvider")
    fun `fibonacci test`(testCase: Pair<Int, Long>) {
        val (n, expected) = testCase
        val actual = strategy.perform(n)
        assertEquals(expected, actual)
    }
}

internal class FibonacciRecursionTest : FibonacciNumberTest<FibonacciRecursion>(FibonacciRecursion())
internal class FibonacciOptimizedRecursionTest :
    FibonacciNumberTest<FibonacciOptimizedRecursion>(FibonacciOptimizedRecursion())

internal class FibonacciBottomUpTest : FibonacciNumberTest<FibonacciBottomUp>(FibonacciBottomUp())
internal class FibonacciTopDownTest : FibonacciNumberTest<FibonacciTopDown>(FibonacciTopDown())
internal class FibonacciIterativeTopDownTest :
    FibonacciNumberTest<FibonacciIterativeTopDown>(FibonacciIterativeTopDown())

internal class FibonacciMatrixExponentiationTest :
    FibonacciNumberTest<FibonacciMatrixExponentiation>(FibonacciMatrixExponentiation())

internal class FibonacciMathTest : FibonacciNumberTest<FibonacciMath>(FibonacciMath())
