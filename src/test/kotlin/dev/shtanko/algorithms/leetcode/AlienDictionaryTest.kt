/*
 * Copyright 2021 Alexey Shtanko
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

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class AlienDictionaryTest<out T : AlienDictionary>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("hello", "leetcode"),
                "hlabcdefgijkmnopqrstuvwxyz",
                true
            ),
            Arguments.of(
                arrayOf("word", "world", "row"),
                "worldabcefghijkmnpqstuvxyz",
                false
            ),
            Arguments.of(
                arrayOf("apple", "app"),
                "abcdefghijklmnopqrstuvwxyz",
                false
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `is alien sorted test`(words: Array<String>, order: String, expected: Boolean) {
        val actual = strategy.isAlienSorted(words, order)
        Assertions.assertEquals(expected, actual)
    }
}

internal class AlienDictionaryCompareTest : AlienDictionaryTest<AlienDictionaryCompare>(AlienDictionaryCompare())