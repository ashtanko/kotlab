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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class TaskSchedulerTest<out T : TaskSchedulerStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<CharArray, Int>, Int>> {
            return listOf(
                charArrayOf('A', 'A', 'A', 'B', 'B', 'B') to 2 to 8,
                charArrayOf('A', 'A', 'A', 'B', 'B', 'B') to 0 to 6,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<CharArray, Int>, Int>) {
        val (data, expected) = testCase
        val (tasks, n) = data
        val actual = strategy.perform(tasks, n)
        assertEquals(expected, actual)
    }
}

class TaskSchedulerSimpleTest : TaskSchedulerTest<TaskSchedulerSimple>(TaskSchedulerSimple())

class TaskSchedulerPriorityQueueTest :
    TaskSchedulerTest<TaskSchedulerPriorityQueue>(TaskSchedulerPriorityQueue())
