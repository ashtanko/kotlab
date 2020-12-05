package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ReachNumberTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                3 to 2,
                2 to 3
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `reach number test`(param: Pair<Int, Int>) {
        val (target, expected) = param
        assertEquals(expected, reachNumber(target))
    }
}
