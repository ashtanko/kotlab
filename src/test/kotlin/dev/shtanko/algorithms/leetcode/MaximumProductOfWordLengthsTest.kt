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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class MaximumProductOfWordLengthsTest<out T : MaximumProductOfWordLengths>(private val solution: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef"),
                16
            ),
            Arguments.of(
                arrayOf("a", "ab", "abc", "d", "cd", "bcd", "abcd"),
                4
            ),
            Arguments.of(
                arrayOf("a", "aa", "aaa", "aaaa"),
                0
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `max product test`(words: Array<String>, expected: Int) {
        val actual = solution.maxProduct(words)
        assertThat(actual).isEqualTo(expected)
    }
}

internal class MaxProductBitmasksTest : MaximumProductOfWordLengthsTest<MaxProductBitmasks>(MaxProductBitmasks())
internal class MaxProductHashmapTest : MaximumProductOfWordLengthsTest<MaxProductHashmap>(MaxProductHashmap())
