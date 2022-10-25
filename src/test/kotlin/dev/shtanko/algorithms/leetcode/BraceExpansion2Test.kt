/*
 * Copyright 2022 Oleksii Shtanko
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
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class BraceExpansion2Test<out T : BraceExpansion2>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "{a,b}{c,{d,e}}",
                listOf("ac", "ad", "ae", "bc", "bd", "be"),
            ),
            Arguments.of(
                "{{a,z},a{b,c},{ab,z}}",
                listOf("a", "ab", "ac", "z"),
            ),
            Arguments.of(
                "",
                listOf(""),
            ),
            Arguments.of(
                "{{a,z}}",
                listOf("a", "z"),
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `brace expansion 2 test`(expression: String, expected: List<String>) {
        val actual = strategy.braceExpansion2(expression)
        assertThat(actual).isEqualTo(expected)
    }
}

class BraceExpansion2DFSTest : BraceExpansion2Test<BraceExpansion2>(BraceExpansion2DFS())
