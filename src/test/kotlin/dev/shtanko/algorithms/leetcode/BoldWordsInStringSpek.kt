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

package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object BoldWordsInStringSpek : Spek({
    describe("Bold Words in String Test") {
        val solution by memoized { BoldWordsInString() }

        it("empty data test") {
            val actual = solution.perform(arrayOf(), "")
            assertThat(actual, equalTo(""))
        }

        it("ab bc test") {
            val actual = solution.perform(arrayOf("ab", "bc"), "aabcd")
            assertThat(actual, equalTo("a<b>abc</b>d"))
        }
    }
})
