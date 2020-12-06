package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class ShortestPalindromeTest<out T : ShortestPalindromeStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("", ""),
                Arguments.of("aacecaaa", "aaacecaaa"),
                Arguments.of("abcd", "dcbabcd"),
                Arguments.of("fffr", "rfffr"),
                Arguments.of("shtanko", "oknathshtanko"),
                Arguments.of("TENET", "TENET"),
                Arguments.of("^^^%", "%^^^%"),
                Arguments.of("&^&^%$%^$^%", "%^\$^%\$%^&^&^%\$%^\$^%")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `shortest palindrome test`(s: String, expected: String) {
        val actual = strategy.perform(s)
        assertEquals(expected, actual)
    }
}

internal class ShortestPalindromeBruteForceTest :
    ShortestPalindromeTest<ShortestPalindromeBruteForce>(ShortestPalindromeBruteForce())

internal class ShortestPalindromeTwoPointersTest :
    ShortestPalindromeTest<ShortestPalindromeTwoPointers>(ShortestPalindromeTwoPointers())

internal class ShortestPalindromeMPTest : ShortestPalindromeTest<ShortestPalindromeMP>(ShortestPalindromeMP())
