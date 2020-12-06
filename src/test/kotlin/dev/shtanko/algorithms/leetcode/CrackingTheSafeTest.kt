package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class CrackingTheSafeTest<out T : CrackingSafeStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(1, 1, "0")
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

internal class CrackingSafeHierholzersAlgorithmTest :
    CrackingTheSafeTest<CrackingSafeHierholzersAlgorithm>(CrackingSafeHierholzersAlgorithm())

internal class CrackingSafeInverseBurrowsWheelerTransformTest :
    CrackingTheSafeTest<CrackingSafeInverseBurrowsWheelerTransform>(CrackingSafeInverseBurrowsWheelerTransform())
