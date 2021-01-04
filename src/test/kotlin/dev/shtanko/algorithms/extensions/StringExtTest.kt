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

package dev.shtanko.algorithms.extensions

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StringExtTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("1", true),
            Arguments.of("0", true),
            Arguments.of("01", true),
            Arguments.of("A", false),
            Arguments.of("1A", false),
            Arguments.of("", false),
            Arguments.of(" ", false),
            Arguments.of(",", false),
            Arguments.of("a", false),
            Arguments.of("11111111111A", false),
            Arguments.of("111111111110000000", true)
        )
    }

    internal class InputPrefixArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "",
                "",
                ""
            ),
            Arguments.of(
                "a",
                "a",
                "a"
            ),
            Arguments.of(
                "abc",
                "ab",
                "ab"
            ),
            Arguments.of(
                "qwertyuiop",
                "qweryuiop",
                "qwer"
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `is binary test`(str: String, expected: Boolean) {
        val actual = str.isBinary()
        assertThat(actual, equalTo(expected))
    }

    @ParameterizedTest
    @ArgumentsSource(InputPrefixArgumentsProvider::class)
    internal fun `common prefix test`(left: String, right: String, expected: String) {
        val actual = (left to right).commonPrefix()
        assertThat(actual, equalTo(expected))
    }
}
