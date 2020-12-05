package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal data class BuddyStringsTestCase(
    val buddyString: Pair<String, String>,
    val expected: Boolean
)

internal class BuddyStringsTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<BuddyStringsTestCase> {
            return listOf(
                BuddyStringsTestCase("ab" to "ba", true),
                BuddyStringsTestCase("ab" to "ab", false),
                BuddyStringsTestCase("aa" to "aa", true),
                BuddyStringsTestCase("aaaaaaabc" to "aaaaaaacb", true),
                BuddyStringsTestCase("" to "aa", false)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `buddy strings test`(testCase: BuddyStringsTestCase) {
        val actual = testCase.buddyString.buddyStrings()
        assertEquals(testCase.expected, actual)
    }
}
