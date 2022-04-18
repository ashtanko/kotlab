/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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
