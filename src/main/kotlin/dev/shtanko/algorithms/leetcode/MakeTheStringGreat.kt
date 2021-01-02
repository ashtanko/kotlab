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

import java.util.Stack
import kotlin.math.abs

/**
 * Make The String Great.
 * @link https://leetcode.com/problems/make-the-string-great/
 */
object MakeTheStringGreat {

    private const val ASCII_A = 97
    private const val ASCII_a = 65

    fun perform(s: String): String {
        val stack: Stack<Char> = Stack()
        for (i in s.indices) {
            if (!stack.isEmpty() && abs(stack.peek() - s[i]) == ASCII_A - ASCII_a) stack.pop() else stack.push(
                s[i]
            )
        }
        val res = CharArray(stack.size)
        var index: Int = stack.size - 1
        while (!stack.isEmpty()) {
            res[index--] = stack.pop()
        }
        return String(res)
    }
}
