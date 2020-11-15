package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class SumOfAllOddLengthSubArraysTest<out T : SumOfAllOddLengthSubArraysStrategy>(private val strategy: T) {

    companion object {
        fun dataProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 4, 2, 5, 3), 58),
            Arguments.of(intArrayOf(1, 2), 3),
            Arguments.of(intArrayOf(10, 11, 12), 66)
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(arr: IntArray, expected: Int) {
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

class SumOfAllOddLengthSubArraysSFTest :
    SumOfAllOddLengthSubArraysTest<SumOfAllOddLengthSubArraysSF>(SumOfAllOddLengthSubArraysSF())
