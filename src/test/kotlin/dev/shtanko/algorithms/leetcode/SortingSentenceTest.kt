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
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class SortingSentenceTest {
    @TestFactory
    fun `sort sentence test`() = listOf(
        "is2 sentence4 This1 a3" to "This is a sentence",
        "Myself2 Me1 I4 and3" to "Me Myself and I",
    )
        .map { (input, expected) ->
            DynamicTest.dynamicTest("when sort $input output is: $expected") {
                val actual = sortSentence(input)
                assertThat(actual).isEqualTo(expected)
            }
        }
}
