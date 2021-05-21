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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class DayOfTheWeekTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Triple<Int, Int, Int>, String>> {
            return listOf(
                Triple(28, 2, 2019) to "Thursday",
                Triple(31, 8, 2019) to "Saturday",
                Triple(18, 7, 1999) to "Sunday",
                Triple(15, 8, 1993) to "Sunday",
                Triple(23, 4, 1994) to "Saturday",
                Triple(27, 10, 1999) to "Wednesday",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `day of the week test`(testCase: Pair<Triple<Int, Int, Int>, String>) {
        val (date, expected) = testCase
        val actual = date.dayOfTheWeek()
        assertEquals(expected, actual)
    }
}
