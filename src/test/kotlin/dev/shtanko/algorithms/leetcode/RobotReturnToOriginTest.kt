package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RobotReturnToOriginTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, Boolean>> {
            return listOf(
                "" to true,
                "UD" to true,
                "LL" to false
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `robot return to origin test`(testCase: Pair<String, Boolean>) {
        val (moves, expected) = testCase
        val actual = judgeCircle(moves)
        assertEquals(expected, actual)
    }
}
