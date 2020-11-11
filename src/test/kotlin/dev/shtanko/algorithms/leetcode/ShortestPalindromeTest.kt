package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class ShortestPalindromeTest<out T : ShortestPalindromeStrategy>(private val strategy: T) {

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
    fun `shortest palindrome test`(s: String, expected: String) {
        val actual = strategy.perform(s)
        assertEquals(expected, actual)
    }
}

class ShortestPalindromeBruteForceTest :
    ShortestPalindromeTest<ShortestPalindromeBruteForce>(ShortestPalindromeBruteForce())

class ShortestPalindromeTwoPointersTest :
    ShortestPalindromeTest<ShortestPalindromeTwoPointers>(ShortestPalindromeTwoPointers())

class ShortestPalindromeMPTest : ShortestPalindromeTest<ShortestPalindromeMP>(ShortestPalindromeMP())
