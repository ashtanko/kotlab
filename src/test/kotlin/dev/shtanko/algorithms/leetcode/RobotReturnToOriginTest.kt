package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RobotReturnToOriginTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, String>> {
            return listOf(
                true to "UD",
                false to "LL"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Boolean, String>) {
        val moves = testCase.second
        val actual = judgeCircle(moves)
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
