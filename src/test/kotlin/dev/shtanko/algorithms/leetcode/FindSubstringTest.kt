package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class AbstractFindSubstringTest<T : AbstractFindSubstring>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, Array<String>>, List<Int>>> {
            return listOf(
                "" to arrayOf("foo", "bar") to listOf(),
                "barfoothefoobarman" to arrayOf("foo", "bar") to listOf(0, 9),
                "wordgoodgoodgoodbestword" to arrayOf("word", "good", "best", "word") to emptyList(),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `find substring test`(testCase: Pair<Pair<String, Array<String>>, List<Int>>) {
        val (data, expected) = testCase
        val (str, words) = data
        val actual = strategy.perform(str, words)
        assertEquals(expected, actual)
    }
}

internal class FindSubstringTest : AbstractFindSubstringTest<FindSubstring>(FindSubstring())
