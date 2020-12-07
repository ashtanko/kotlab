package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CrackingSafeHierholzersAlgorithmTest {

    private val strategy = CrackingSafeHierholzersAlgorithm()

    companion object {
        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(1, 1, "0"),
                Arguments.of(1, 2, "10"),
                Arguments.of(2, 2, "01100"),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `cracking the safe test`(n: Int, k: Int, expected: String) {
        val actual = strategy.perform(n, k)
        assertEquals(expected, actual)
    }
}

internal class CrackingSafeInverseBurrowsWheelerTransformTest {

    private val strategy = CrackingSafeInverseBurrowsWheelerTransform()

    companion object {
        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(1, 1, "0"),
                Arguments.of(1, 2, "01"),
                Arguments.of(2, 2, "00110"),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `cracking the safe test`(n: Int, k: Int, expected: String) {
        val actual = strategy.perform(n, k)
        assertEquals(expected, actual)
    }
}
