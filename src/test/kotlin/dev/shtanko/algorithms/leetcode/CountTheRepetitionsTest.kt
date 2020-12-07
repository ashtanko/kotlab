package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class CountTheRepetitionsTest<out T : CountTheRepetitionsStrategy>(private val strategy: T) {
    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("", 0, "", 0, 0),
                Arguments.of("", 0, "", 1, 0),
                Arguments.of("acb", 4, "ab", 2, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `count the repetitions test`(s1: String, n1: Int, s2: String, n2: Int, expected: Int) {
        val actual = strategy.perform(s1, n1, s2, n2)
        assertEquals(expected, actual)
    }
}

internal class CountTheRepetitionsBruteForceTest :
    CountTheRepetitionsTest<CountTheRepetitionsBruteForce>(CountTheRepetitionsBruteForce())

internal class CountTheRepetitionsBetterBruteForceTest :
    CountTheRepetitionsTest<CountTheRepetitionsBetterBruteForce>(CountTheRepetitionsBetterBruteForce())
