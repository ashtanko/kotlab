package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class DefangingIPAddressTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, String>> {
            return listOf(
                "1.1.1.1" to "1[.]1[.]1[.]1",
                "255.100.50.0" to "255[.]100[.]50[.]0"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `defang IP address naive test`(testCase: Pair<String, String>) {
        val (address, expected) = testCase
        val actual = address.defangIPaddrNaive()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `defang IP address test`(testCase: Pair<String, String>) {
        val (address, expected) = testCase
        val actual = address.defangIPaddr()
        assertEquals(expected, actual)
    }
}
