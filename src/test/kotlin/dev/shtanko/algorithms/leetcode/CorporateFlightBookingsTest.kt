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

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CorporateFlightBookingsTest {

    companion object {

        @JvmStatic
        private fun provideDataFlights(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 2, 10),
                        intArrayOf(2, 3, 20),
                        intArrayOf(2, 5, 25)
                    ),
                    5,
                    intArrayOf(10, 55, 45, 25, 25)
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataFlights")
    internal fun `corporate flight bookings test`(bookings: Array<IntArray>, n: Int, expected: IntArray) {
        val actual = corpFlightBookings(bookings, n)
        assertArrayEquals(expected, actual)
    }
}
