/*
 * Copyright 2020 Alexey Shtanko
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

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BestSightseeingPairTest {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(intArrayOf(8, 1, 5, 2, 6), 11)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `best sightseeing pair test`(arr: IntArray, expected: Int) {
        val actual = maxScoreSightseeingPair(arr)
        assertEquals(expected, actual)
    }
}
