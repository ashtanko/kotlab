package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class AbstractFindSubstringTest<T : AbstractFindSubstring>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, Array<String>>, List<Int>>> {
            return listOf(
                "barfoothefoobarman" to arrayOf("foo", "bar") to listOf(0, 9),
                "wordgoodgoodgoodbestword" to arrayOf("word", "good", "best", "word") to emptyList()
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<String, Array<String>>, List<Int>>) {
        val str = testCase.first.first
        val words = testCase.first.second
        val actual = strategy.perform(str, words)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

class FindSubstringTest : AbstractFindSubstringTest<FindSubstring>(FindSubstring())
