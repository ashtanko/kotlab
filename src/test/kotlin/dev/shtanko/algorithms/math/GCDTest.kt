package dev.shtanko.algorithms.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class GCDTest {

    companion object {
        @JvmStatic
        fun dataProvider(): Stream<Arguments?> = Stream.of(
            Arguments.of(54, 24, 6),
            Arguments.of(42, 56, 14)
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `gcd pair test`(a: Int, b: Int, expected: Int) {
        val actual = (a to b).gcd()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `gcd recursive test`(a: Int, b: Int, expected: Int) {
        val actual = gcd(a, b)
        assertEquals(expected, actual)
    }
}
