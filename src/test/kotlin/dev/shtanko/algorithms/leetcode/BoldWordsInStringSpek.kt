package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object BoldWordsInStringSpek : Spek({
    describe("Bold Words in String Test") {
        val solution by memoized { BoldWordsInString() }

        it("empty data test") {
            val actual = solution.perform(arrayOf(), "")
            assertThat(actual, equalTo(""))
        }

        it("ab bc test") {
            val actual = solution.perform(arrayOf("ab", "bc"), "aabcd")
            assertThat(actual, equalTo("a<b>abc</b>d"))
        }
    }
})
