package dev.shtanko.algorithms.leetcode

import dev.shtanko.util.assertListEquals
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SubdomainVisitCountTest {
    @Test
    fun `simple test`() {
        val cpdomains = arrayOf("9001 discuss.leetcode.com")
        val expected = listOf("9001 com", "9001 leetcode.com", "9001 discuss.leetcode.com")
        val actual = cpdomains.subdomainVisits()
        assertEquals(expected, actual)
        assertTrue(assertListEquals(expected, actual))
    }

    @Test
    fun `simple test 2`() {
        val cpdomains = arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")
        val expected = listOf(
            "951 com",
            "900 google.mail.com",
            "1 intel.mail.com",
            "5 org",
            "5 wiki.org",
            "901 mail.com",
            "50 yahoo.com"
        )
        val actual = cpdomains.subdomainVisits()
        assertThat(expected).isEqualTo(actual)
    }
}
