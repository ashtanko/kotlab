package dev.shtanko.algorithms.codility

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class BinaryGapTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                1041 to 5,
                15 to 0,
                32 to 0,
                10 to 1,
                101 to 2,
                9 to 2,
                1162 to 3,
                51712 to 2,
                561892 to 3,
                66561 to 9,
                6291457 to 20,
                1610612737 to 28,
                1073741825 to 29,
                1376796946 to 5,
                805306373 to 25,
                74901729 to 4,
                6 to 0
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Int, Int>) {
        val n = testCase.first
        val expected = testCase.second
        val actual = findBinaryGap(n)
        assertEquals(expected, actual)
    }
}
