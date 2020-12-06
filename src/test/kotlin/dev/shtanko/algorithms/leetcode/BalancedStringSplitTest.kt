package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class BalancedStringSplitTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                "RLRRLLRLRL" to 4,
                "RLLLLRRRLR" to 3,
                "LLLLRRRR" to 1,
                "RLRRRLLRLL" to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `balanced string split test`(param: Pair<String, Int>) {
        val (str, expected) = param
        val actual = str.balancedStringSplit()
        assertEquals(expected, actual)
    }
}
