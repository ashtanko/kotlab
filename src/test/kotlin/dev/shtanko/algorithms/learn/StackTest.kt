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

package dev.shtanko.algorithms.learn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.Stack

class StackTest {

    companion object {
        @JvmStatic
        fun reverseStringProvider(): List<Pair<String, String>> {
            return listOf(
                "rap" to "par",
                "car" to "rac",
                "tenet" to "tenet"
            )
        }
    }

    @Test
    fun `sort values in stack`() {
        val stack = Stack<Int>().apply {
            push(4)
            push(1)
            push(5)
            push(2)
            push(9)
            push(34)
            push(0)
        }
        assertEquals(listOf(4, 1, 5, 2, 9, 34, 0), stack.toList())
        val sorted = stack.sorted()
        assertEquals(listOf(0, 1, 2, 4, 5, 9, 34), sorted.toList())
    }

    @ParameterizedTest
    @MethodSource("reverseStringProvider")
    fun `reverse string using stack`(testCase: Pair<String, String>) {
        val str = testCase.first
        val actual = str.reversed()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
