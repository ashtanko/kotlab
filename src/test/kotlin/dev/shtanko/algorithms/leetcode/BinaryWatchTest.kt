/*
 * Copyright 2021 Oleksii Shtanko
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
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class BinaryWatchTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                listOf(
                    "0:03",
                    "0:05",
                    "0:06",
                    "0:09",
                    "0:10",
                    "0:12",
                    "0:17",
                    "0:18",
                    "0:20",
                    "0:24",
                    "0:33",
                    "0:34",
                    "0:36",
                    "0:40",
                    "0:48",
                    "1:01",
                    "1:02",
                    "1:04",
                    "1:08",
                    "1:16",
                    "1:32",
                    "2:01",
                    "2:02",
                    "2:04",
                    "2:08",
                    "2:16",
                    "2:32",
                    "3:00",
                    "4:01",
                    "4:02",
                    "4:04",
                    "4:08",
                    "4:16",
                    "4:32",
                    "5:00",
                    "6:00",
                    "8:01",
                    "8:02",
                    "8:04",
                    "8:08",
                    "8:16",
                    "8:32",
                    "9:00",
                    "10:00",
                ),
            ),
            Arguments.of(
                0,
                listOf("0:00"),
            ),
            Arguments.of(
                1,
                listOf("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"),
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `binary watch test`(n: Int, expected: List<String>) {
        val actual = BinaryWatch.perform(n)
        println(actual)
        assertThat(actual, containsInAnyOrder(*expected.toTypedArray()))
    }
}
