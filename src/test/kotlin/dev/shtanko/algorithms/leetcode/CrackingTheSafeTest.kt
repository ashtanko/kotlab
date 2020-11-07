package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class CrackingTheSafeTest<out T : CrackingSafeStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(1, 1, "0"),
                // Arguments.of(1, 2, "10"),
                // Arguments.of(2, 2, "01100")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    fun `cracking the safe test`(n: Int, k: Int, expected: String) {
        val actual = strategy.perform(n, k)
        assertEquals(expected, actual)
    }
}

class CrackingSafeHierholzersAlgorithmTest :
    CrackingTheSafeTest<CrackingSafeHierholzersAlgorithm>(CrackingSafeHierholzersAlgorithm())

class CrackingSafeInverseBurrowsWheelerTransformTest :
    CrackingTheSafeTest<CrackingSafeInverseBurrowsWheelerTransform>(CrackingSafeInverseBurrowsWheelerTransform())
