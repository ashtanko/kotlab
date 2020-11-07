package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class JumpGameTest {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Boolean>> = listOf(
            intArrayOf(2, 3, 1, 1, 4) to true,
            intArrayOf(3, 2, 1, 0, 4) to false
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `can jump test`(testCase: Pair<IntArray, Boolean>) {
        val arr = testCase.first
        val actual = arr.canJump()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
