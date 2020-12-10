package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class BinaryGapTest<out T : BinaryGapStrategy>(private val strategy: T) {

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
                Int.MAX_VALUE to 1,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Pair<Int, Int>) {
        val (n, expected) = testCase
        val actual = strategy.binaryGap(n)
        assertEquals(expected, actual)
    }
}

internal class BGStoreIndexesTest : BinaryGapTest<BGStoreIndexes>(BGStoreIndexes())

internal class BGOnePassTest : BinaryGapTest<BGOnePass>(BGOnePass())

internal class BGOtherTest : BinaryGapTest<BGOther>(BGOther())
