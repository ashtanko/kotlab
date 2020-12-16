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

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal abstract class AddDigitsTest<out T : AddDigitsStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(38, 2),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `add digits test`(digits: Int, expected: Int) {
        val actual = strategy.perform(digits)
        assertThat(actual, equalTo(expected))
    }
}

internal class AddDigitsStraightForwardTest : AddDigitsTest<AddDigitsStraightForward>(AddDigitsStraightForward())
internal class AddDigitsMathTest : AddDigitsTest<AddDigitsMath>(AddDigitsMath())
