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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class GrayCodeTest {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(2, listOf(0, 1, 3, 2)),
            Arguments.of(1, listOf(0, 1)),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `gray code backtracking test`(n: Int, expected: List<Int>) {
        assertGrayCode(GrayCode::backtracking, n, expected)
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `gray code recursion test`(n: Int, expected: List<Int>) {
        assertGrayCode(GrayCode::recursion, n, expected)
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `gray code iteration test`(n: Int, expected: List<Int>) {
        assertGrayCode(GrayCode::iteration, n, expected)
    }

    private fun assertGrayCode(f: (Int) -> List<Int>, n: Int, expected: List<Int>) {
        val actual = f.invoke(n)
        assertThat(actual).containsAll(expected)
    }
}
