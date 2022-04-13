/*
 * Copyright 2022 Alexey Shtanko
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

abstract class MakeArrayStrictlyIncreasingTest<out T : MakeArrayStrictlyIncreasing>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 5, 3, 6, 7),
                intArrayOf(1, 3, 2, 4),
                1
            ),
            Arguments.of(
                intArrayOf(1, 5, 3, 6, 7),
                intArrayOf(4, 3, 1),
                2
            ),
            Arguments.of(
                intArrayOf(1, 5, 3, 6, 7),
                intArrayOf(1, 6, 3, 3),
                -1
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `make array increasing test`(arr1: IntArray, arr2: IntArray, expected: Int) {
        val actual = strategy.perform(arr1, arr2)
        assertThat(actual).isEqualTo(expected)
    }
}

class MakeArrayStrictlyIncreasingDPTest :
    MakeArrayStrictlyIncreasingTest<MakeArrayStrictlyIncreasing>(MakeArrayStrictlyIncreasingDP())