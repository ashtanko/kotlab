package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class CountTheRepetitionsTest<out T : CountTheRepetitionsStrategy>(private val strategy: T) {
    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("acb", 4, "ab", 2, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    fun `count the repetitions test`(s1: String, n1: Int, s2: String, n2: Int, expected: Int) {
        val actual = strategy.perform(s1, n1, s2, n2)
        assertEquals(expected, actual)
    }
}

class CountTheRepetitionsBruteForceTest :
    CountTheRepetitionsTest<CountTheRepetitionsBruteForce>(CountTheRepetitionsBruteForce())

class CountTheRepetitionsBetterBruteForceTest :
    CountTheRepetitionsTest<CountTheRepetitionsBetterBruteForce>(CountTheRepetitionsBetterBruteForce())
