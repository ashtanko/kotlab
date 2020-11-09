package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class InterleavingStringTest<out T : InterleavingStringStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("aabcc", "dbbca", "aadbbcbcac", true),
                Arguments.of("aabcc", "dbbca", "aadbbbaccc", false),
                Arguments.of("", "", "", true),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    fun `interleaving string test`(s1: String, s2: String, s3: String, expected: Boolean) {
        val actual = strategy.perform(s1, s2, s3)
        assertEquals(expected, actual)
    }
}

class InterleavingStringBruteForceTest :
    InterleavingStringTest<InterleavingStringBruteForce>(InterleavingStringBruteForce())

class InterleavingStringRecursionWithMemoTest :
    InterleavingStringTest<InterleavingStringRecursionWithMemo>(InterleavingStringRecursionWithMemo())

class InterleavingString2DTest : InterleavingStringTest<InterleavingString2D>(InterleavingString2D())

class InterleavingString1DTest : InterleavingStringTest<InterleavingString1D>(InterleavingString1D())
