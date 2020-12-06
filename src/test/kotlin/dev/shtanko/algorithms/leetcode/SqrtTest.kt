package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class SqrtTest<out T : SqrtStrategy>(private val strategy: T) {
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                0 to 0,
                1 to 1,
                4 to 2,
                9 to 3,
                16 to 4,
                25 to 5,
                36 to 6,
                49 to 7,
                64 to 8,
                81 to 9,
                100 to 10,
                121 to 11,
                144 to 12,
                169 to 13,
                196 to 14,
                225 to 15,
                256 to 16,
                289 to 17,
                324 to 18,
                361 to 19,
                400 to 20,
                441 to 21,
                484 to 22,
                529 to 23,
                576 to 24
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `sqrt test`(testCase: Pair<Int, Int>) {
        val (n, expected) = testCase
        val actual = strategy.mySqrt(n)
        assertEquals(expected, actual)
    }
}

internal class SqrtBSTest : SqrtTest<SqrtBS>(SqrtBS())

internal class SqrtNewtonTest : SqrtTest<SqrtNewton>(SqrtNewton())

internal class SqrtBruteForceTest : SqrtTest<SqrtBruteForce>(SqrtBruteForce())
