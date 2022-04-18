/*
 * Copyright 2022 Oleksii Shtanko
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

object StrStr {
    fun perform(haystack: String, needle: String) = solve(haystack, needle)

    private tailrec fun solve(stack: String, needle: String, count: Int = 0): Int =
        when {
            stack.length < needle.length -> -1
            stack.startsWith(needle) -> count
            else -> solve(stack.drop(1), needle, count + 1)
        }
}
