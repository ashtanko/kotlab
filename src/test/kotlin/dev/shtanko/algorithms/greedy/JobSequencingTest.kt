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

package dev.shtanko.algorithms.greedy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JobSequencingTest {

    @Test
    fun `simple test`() {
        val j1 = Job('a', 2, 100)
        val j2 = Job('b', 1, 19)
        val j3 = Job('c', 2, 27)
        val j4 = Job('d', 1, 25)
        val j5 = Job('e', 3, 15)

        val arr = arrayOf(j1, j2, j3, j4, j5)
        val actual = arr.scheduleJobs()
        val expected = listOf('c', 'a', 'e')
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = arrayOf(
            Job('a', 3, 30),
            Job('b', 5, 12),
            Job('c', 1, 2),
            Job('d', 7, 25),
            Job('e', 12, 5),
            Job('f', 12, 5)
        )
        val actual = arr.scheduleJobs()
        println(actual.toList())
        val expected = listOf('c', 'f', 'a', 'e', 'b', 'd')
        assertEquals(expected, actual)
    }
}
