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

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class LongestCommonPrefixTest<out T : LongestCommonPrefix>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                emptyArray<String>(),
                ""
            ),
            Arguments.of(
                arrayOf("flower", "flow", "flight", "flstudio"),
                "fl"
            ),
            Arguments.of(
                arrayOf("dog", "racecar", "car"),
                ""
            ),
            Arguments.of(
                arrayOf("alsad", "alrty"),
                "al"
            ),
            Arguments.of(
                arrayOf("leets", "leetcode", "leet", "leeds"),
                "lee"
            ),
            Arguments.of(
                arrayOf("leetcode", "leet", "le"),
                "le"
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `longest common prefix test`(strs: Array<String>, expected: String) {
        val actual = strategy.perform(strs)
        assertThat(actual, equalTo(expected))
    }
}

internal class LCPHorizontalScanningTest : LongestCommonPrefixTest<LCPHorizontalScanning>(LCPHorizontalScanning())
internal class LCPVerticalScanningTest : LongestCommonPrefixTest<LCPVerticalScanning>(LCPVerticalScanning())
internal class LCPDivideAndConquerTest : LongestCommonPrefixTest<LCPDivideAndConquer>(LCPDivideAndConquer())
