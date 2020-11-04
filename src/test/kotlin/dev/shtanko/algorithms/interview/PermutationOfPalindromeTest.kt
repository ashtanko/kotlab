package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PermutationOfPalindromeTest {

    companion object {

        @JvmStatic
        fun dataProvider() = listOf(
            "tactcoa" to true,
            "abcdefg" to false,
            "aaaa" to true,
            "aaaabbbb" to true,
            "aaaacbbb" to false
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `is permutation of palindrome test`(testCase: Pair<String, Boolean>) {
        val actual = testCase.first.isPermutationOfPalindrome()
        if (testCase.second) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
