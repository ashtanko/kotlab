/*
 * Copyright 2021 Oleksii Shtanko
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

import java.util.Stack
import kotlin.math.abs

/**
 * Make The String Great.
 * @see <a href="https://leetcode.com/problems/make-the-string-great/">Source</a>
 */
fun interface MakeTheStringGreat {
    operator fun invoke(s: String): String
}

/**
 * Approach 1: Iteration.
 */
class MakeTheStringGreatIteration : MakeTheStringGreat {

    companion object {
        private const val SIZE = 32
    }

    override operator fun invoke(s: String): String {
        val newS = StringBuilder(s)

        // if s has less than 2 characters, we just return itself.
        while (newS.length > 1) {
            // 'find' records if we find any pair to remove.
            var find = false

            // Check every two adjacent characters, currChar and nextChar.
            for (i in 0 until newS.length - 1) {
                val currChar = newS[i]
                val nextChar = newS[i + 1]

                // If they make a pair, remove them from 's' and let 'find = true'.
                if (abs(currChar.code - nextChar.code) == SIZE) {
                    newS.deleteCharAt(i)
                    newS.deleteCharAt(i)
                    find = true
                    break
                }
            }

            // If we cannot find any pair to remove, break the loop.
            if (!find) break
        }
        return newS.toString()
    }
}

/**
 * Approach 2: Recursion
 */
class MakeTheStringGreatRecursion : MakeTheStringGreat {

    companion object {
        private const val SIZE = 32
    }

    override operator fun invoke(s: String): String {
        // If we find a pair in 's', remove this pair from 's'
        // and solve the remaining string recursively.
        for (i in 0 until s.length - 1) {
            if (abs(s[i] - s[i + 1]) == SIZE) {
                return invoke(s.substring(0, i) + s.substring(i + 2))
            }
        }

        // Base case, if we can't find a pair, just return 's'.
        return s
    }
}

class MakeTheStringGreatStack : MakeTheStringGreat {

    companion object {
        private const val ASCII_UPPER_CASE = 97
        private const val ASCII_LOWER_CASE = 65
    }

    override operator fun invoke(s: String): String {
        val stack: Stack<Char> = Stack()
        for (i in s.indices) {
            if (!stack.isEmpty() && abs(stack.peek() - s[i]) == ASCII_UPPER_CASE - ASCII_LOWER_CASE) {
                stack.pop()
            } else {
                stack.push(s[i])
            }
        }
        val res = CharArray(stack.size)
        var index: Int = stack.size - 1
        while (!stack.isEmpty()) {
            res[index--] = stack.pop()
        }
        return String(res)
    }
}
