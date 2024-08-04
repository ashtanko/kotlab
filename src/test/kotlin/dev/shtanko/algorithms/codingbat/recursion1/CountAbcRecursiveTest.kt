/*
 * Copyright 2024 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.codingbat.recursion1

import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class CountAbcTest<out T : CountAbc>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "",
                0,
            ),
            Arguments.of(
                "abc",
                1,
            ),
            Arguments.of(
                "acc",
                0,
            ),
            Arguments.of(
                "aba",
                1,
            ),
            Arguments.of(
                "abcxxabc",
                2,
            ),
            Arguments.of(
                "abcxxabc",
                2,
            ),
            Arguments.of(
                "aaa",
                0,
            ),
            Arguments.of(
                "aca",
                0,
            ),
            Arguments.of(
                "aaabc",
                1,
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `count abc test`(str: String, expected: Int) {
        val actual = strategy(str)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class CountAbcIterativeTest : CountAbcTest<CountAbc>(CountAbcIterative())
class CountAbcRecursiveTest : CountAbcTest<CountAbc>(CountAbcRecursive())
