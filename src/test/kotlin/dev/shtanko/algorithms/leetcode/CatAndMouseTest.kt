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

abstract class CatAndMouseTest<out T : CatAndMouse>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 5),
                    intArrayOf(3),
                    intArrayOf(0, 4, 5),
                    intArrayOf(1, 4, 5),
                    intArrayOf(2, 3),
                    intArrayOf(0, 2, 3),
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(0),
                    intArrayOf(3),
                    intArrayOf(0, 2),
                ),
                1
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `cat mouse game test`(graph: Array<IntArray>, expected: Int) {
        val actual = strategy.catMouseGame(graph)
        assertThat(actual).isEqualTo(expected)
    }
}

class CatAndMouseMinimaxTest : CatAndMouseTest<CatAndMouseMinimax>(CatAndMouseMinimax())