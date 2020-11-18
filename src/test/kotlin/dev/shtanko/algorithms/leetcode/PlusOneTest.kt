package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PlusOneTest {
    companion object {

        @JvmStatic
        fun dataProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4)),
            Arguments.of(intArrayOf(4, 3, 2, 1), intArrayOf(4, 3, 2, 2)),
            Arguments.of(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1)),
            Arguments.of(intArrayOf(0), intArrayOf(1)),
            Arguments.of(intArrayOf(0, 0), intArrayOf(0, 1)),
            Arguments.of(intArrayOf(), intArrayOf(1))
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(arr: IntArray, expected: IntArray) {
        val actual = PlusOne().perform(arr)
        assertArrayEquals(expected, actual)
    }
}
