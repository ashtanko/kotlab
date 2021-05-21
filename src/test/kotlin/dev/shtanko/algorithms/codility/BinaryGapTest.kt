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

package dev.shtanko.algorithms.codility

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BinaryGapTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of()
    }

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                1041 to 5,
                15 to 0,
                32 to 0,
                10 to 1,
                101 to 2,
                9 to 2,
                1162 to 3,
                51712 to 2,
                561892 to 3,
                66561 to 9,
                6291457 to 20,
                1610612737 to 28,
                1073741825 to 29,
                1376796946 to 5,
                805306373 to 25,
                74901729 to 4,
                6 to 0
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("find binary gap test")
    fun `simple test`(testCase: Pair<Int, Int>) {
        val n = testCase.first
        val expected = testCase.second
        val actual = findBinaryGap(n)
        assertEquals(expected, actual)
    }
}
