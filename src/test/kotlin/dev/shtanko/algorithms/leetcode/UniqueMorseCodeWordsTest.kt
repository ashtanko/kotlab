package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueMorseCodeWordsTest {

    @Test
    fun `simple test`() {
        val words = arrayOf(
            "gin", "zen", "gig", "msg"
        )
        assertEquals(2, words.uniqueMorseRepresentations())
    }
}
