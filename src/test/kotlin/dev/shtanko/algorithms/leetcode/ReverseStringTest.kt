package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ReverseStringTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<CharArray, CharArray>> {
            return listOf(
                charArrayOf() to charArrayOf(),
                charArrayOf('h', 'e', 'l', 'l', 'o') to charArrayOf('o', 'l', 'l', 'e', 'h'),
                charArrayOf('T', 'E', 'N', 'E', 'T') to charArrayOf('T', 'E', 'N', 'E', 'T'),
                charArrayOf('2', '1') to charArrayOf('1', '2'),
                charArrayOf('$', '%') to charArrayOf('%', '$')
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `reverse string test`(testCase: Pair<CharArray, CharArray>) {
        val arr = testCase.first
        arr.reverse()
        val expected = testCase.second
        assertArrayEquals(expected, arr)
    }
}
