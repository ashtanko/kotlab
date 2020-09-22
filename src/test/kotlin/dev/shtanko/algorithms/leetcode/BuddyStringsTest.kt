package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

data class BuddyStringsTestCase(
    val pair: Pair<String, String>,
    val assertMethod: Boolean
)

class BuddyStringsTest {

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
    fun `buddy strings test`(testCase: BuddyStringsTestCase) {
        val actual = testCase.pair.buddyStrings()
        if (testCase.assertMethod) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
