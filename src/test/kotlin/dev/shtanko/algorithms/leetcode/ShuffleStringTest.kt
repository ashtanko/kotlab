package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ShuffleStringTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, String>, String>> {
            return listOf(
                (intArrayOf(4, 5, 6, 7, 0, 2, 1, 3) to "codeleet") to "leetcode",
                (intArrayOf(0, 1, 2) to "abc") to "abc",
                (intArrayOf(3, 1, 4, 2, 0) to "aiohn") to "nihao",
                (intArrayOf(4, 0, 2, 6, 7, 3, 1, 5) to "aaiougrt") to "arigatou",
                (intArrayOf(1, 0, 2) to "art") to "rat",
                (intArrayOf(3, 4, 5, 6, 0, 1, 2) to "ankosht") to "shtanko"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `restore string test`(testCase: Pair<Pair<IntArray, String>, String>) {
        val s = testCase.first.second
        val indices = testCase.first.first
        val expected = testCase.second
        val actual = (s to indices).restoreString()
        assertEquals(expected, actual)
    }
}
