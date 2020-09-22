package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CanMakeArithmeticProgressionTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                true to listOf(3, 5, 1),
                false to listOf(1, 2, 4),
                false to listOf(0, 1, 4, 9, 16, 25, 36)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `can make arithmetic progression test`(param: Pair<Boolean, List<Int>>) {
        val arr = param.second.toIntArray()
        val actual = arr.canMakeArithmeticProgression()
        assertTrue(!actual || param.first)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `can make arithmetic progression using set test`(param: Pair<Boolean, List<Int>>) {
        val arr = param.second.toIntArray()
        val actual = arr.canMakeArithmeticProgressionSet()
        if (param.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
