package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class AddBinaryTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Triple<String, String, String>> {
            return listOf(
                Triple("11", "1", "100"),
                Triple("1010", "1011", "10101")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(data: Triple<String, String, String>) {
        val (a, b, expected) = data
        val actual = addBinary(a, b)
        assertEquals(expected, actual)
    }
}
