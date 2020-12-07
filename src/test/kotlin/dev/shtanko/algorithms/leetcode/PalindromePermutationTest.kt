package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class PalindromePermutationTest<out T : PalindromePermutationBehavior>(private val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("", true),
            Arguments.of("a", true),
            Arguments.of("tenet", true),
            Arguments.of("abc", false),
            Arguments.of("code", false),
            Arguments.of("aab", true),
            Arguments.of("carerac", true)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `can permute palindrome test`(s: String, expected: Boolean) {
        val actual = strategy.canPermutePalindrome(s)
        assertEquals(expected, actual)
    }
}

internal class PalindromePermutationBruteForceTest :
    PalindromePermutationTest<PalindromePermutationBruteForce>(PalindromePermutationBruteForce())

internal class PalindromePermutationHashMapTest :
    PalindromePermutationTest<PalindromePermutationHashMap>(PalindromePermutationHashMap())

internal class PalindromePermutationArrayTest :
    PalindromePermutationTest<PalindromePermutationArray>(PalindromePermutationArray())

internal class PalindromePermutationSinglePassTest :
    PalindromePermutationTest<PalindromePermutationSinglePass>(PalindromePermutationSinglePass())

internal class PalindromePermutationSetTest :
    PalindromePermutationTest<PalindromePermutationSet>(PalindromePermutationSet())

internal class PalindromePermutationTreeTest :
    PalindromePermutationTest<PalindromePermutationTree>(PalindromePermutationTree())
