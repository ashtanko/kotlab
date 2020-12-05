package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SumOfDistancesInTreeTest {
    companion object {
        @JvmStatic
        fun dataProvider(): Stream<Arguments?> = Stream.of(

            //  0
            //  / \
            // 1   2
            //    /|\
            //   3 4 5
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4),
                    intArrayOf(2, 5)
                ),
                intArrayOf(8, 12, 6, 10, 10, 10)
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `sum of distances in tree test`(n: Int, edges: Array<IntArray>, expected: IntArray) {
        val actual = SumOfDistancesInTree().perform(n, edges)
        assertArrayEquals(expected, actual)
    }
}
