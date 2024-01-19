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

package dev.shtanko.algorithms.codingbat

import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class Array11Test<out T : Array11>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 11),
                0,
                1,
            ),
            Arguments.of(
                intArrayOf(11, 11),
                0,
                2,
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                0,
                0,
            ),
            Arguments.of(
                intArrayOf(),
                0,
                0,
            ),
            Arguments.of(
                intArrayOf(1),
                0,
                0,
            ),
            Arguments.of(
                intArrayOf(11, 11),
                1,
                1,
            ),
            Arguments.of(
                intArrayOf(11, 11, 12, 11),
                2,
                1,
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `array 11 test`(nums: IntArray, index: Int, expected: Int) {
        val actual = strategy(nums, index)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class Array11IterativeTest : Array11Test<Array11>(Array11Iterative())
class Array11RecursiveTest : Array11Test<Array11>(Array11Recursive())