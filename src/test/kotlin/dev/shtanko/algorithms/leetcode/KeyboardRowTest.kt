package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class KeyboardRowTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<String>, Array<String>>> {
            return listOf(
                arrayOf("Hello", "Alaska", "Dad", "Peace") to arrayOf("Alaska", "Dad")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `keyboard row test`(testCase: Pair<Array<String>, Array<String>>) {
        val (words, expected) = testCase
        val actual = words.findWords()
        assertArrayEquals(expected, actual)
    }
}
