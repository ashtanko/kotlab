package dev.shtanko.algorithms.leetcode

import dev.shtanko.util.assertListEquals
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class SubdomainVisitCountTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<String>, List<String>>> {
            return listOf(
                arrayOf("9001 discuss.leetcode.com") to listOf(
                    "9001 com",
                    "9001 leetcode.com",
                    "9001 discuss.leetcode.com"
                ),
                arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org") to listOf(
                    "951 com",
                    "900 google.mail.com",
                    "1 intel.mail.com",
                    "5 org",
                    "5 wiki.org",
                    "901 mail.com",
                    "50 yahoo.com"
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `subdomain visits test`(testCase: Pair<Array<String>, List<String>>) {
        val (cpDomains, expected) = testCase
        val actual = cpDomains.subdomainVisits()
        assertEquals(expected, actual)
        assertTrue(assertListEquals(expected, actual))
        assertThat(expected).isEqualTo(actual)
    }
}
