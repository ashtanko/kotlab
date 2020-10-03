package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MajorityCheckerTest {

    private val array = intArrayOf(1, 1, 2, 2, 1, 1)

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Triple<Int, Int, Int>>> {
            return listOf(
                1 to Triple(0, 5, 4),
                -1 to Triple(0, 3, 3),
                2 to Triple(2, 3, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(data: Pair<Int, Triple<Int, Int, Int>>) {
        val s = data.second
        MajorityChecker(array).query(s.first, s.second, s.third)
    }
}
