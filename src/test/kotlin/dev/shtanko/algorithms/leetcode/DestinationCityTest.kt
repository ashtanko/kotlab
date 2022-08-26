/*
 * Copyright 2020 Oleksii Shtanko
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
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource

internal abstract class DestinationCityTest<out T : DestinationCityStrategy>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<List<List<String>>, String>> {
            return listOf(
                emptyList<List<String>>() to "",
                listOf(
                    listOf("London", "New York"),
                    listOf("New York", "Lima"),
                    listOf("Lima", "Sao Paulo"),
                ) to "Sao Paulo",
                listOf(
                    listOf("B", "C"),
                    listOf("D", "B"),
                    listOf("C", "A"),
                ) to "A",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `destination city test`(testCase: Pair<List<List<String>>, String>) {
        val (paths, expected) = testCase
        val actual = strategy.perform(paths)
        assertEquals(expected, actual)
    }
}

internal class DestinationCitySetTest : DestinationCityTest<DestinationCitySet>(DestinationCitySet())

internal class DestinationCityHashMapTest : DestinationCityTest<DestinationCityHashMap>(DestinationCityHashMap())
