package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class FindLuckyTest<out T : FindLuckyStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideNumbers(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(intArrayOf(2, 2, 3, 4), 2),
                Arguments.of(intArrayOf(1, 2, 2, 3, 3, 3), 3),
                Arguments.of(intArrayOf(2, 2, 2, 3, 3), -1),
                Arguments.of(intArrayOf(5), -1),
                Arguments.of(intArrayOf(7, 7, 7, 7, 7, 7, 7), 7),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    fun `simple test`(arr: IntArray, expected: Int) {
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

class FindLuckyStraightForwardTest : FindLuckyTest<FindLuckyStraightForward>(FindLuckyStraightForward())
class FindLuckyMapTest : FindLuckyTest<FindLuckyMap>(FindLuckyMap())
