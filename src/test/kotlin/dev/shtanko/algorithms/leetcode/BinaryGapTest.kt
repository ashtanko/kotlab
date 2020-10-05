package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class BinaryGapTest<out T : BinaryGapStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                22 to 2,
                5 to 2,
                6 to 1,
                8 to 0,
                4 to 0,
                15 to 1,
                7 to 1,
                16 to 0,
                23 to 2,
                42 to 2,
                56 to 1,
                114 to 3,
                2345 to 3,
                Int.MAX_VALUE to 1
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(case: Pair<Int, Int>) {
        val n = case.first
        val expected = case.second
        val actual = strategy.binaryGap(n)
        assertEquals(expected, actual)
    }
}

class BGStoreIndexesTest : BinaryGapTest<BGStoreIndexes>(BGStoreIndexes())

class BGOnePassTest : BinaryGapTest<BGOnePass>(BGOnePass())
