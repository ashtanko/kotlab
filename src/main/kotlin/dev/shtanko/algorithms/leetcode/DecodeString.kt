/*
 * Copyright 2023 Oleksii Shtanko
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

import java.util.Deque
import java.util.LinkedList
import java.util.Stack

/**
 * 394. Decode String
 * @see <a href="https://leetcode.com/problems/decode-string/">Source</a>
 */
fun interface DecodeString {
    operator fun invoke(s: String): String
}

class DecodeStringStack : DecodeString {
    override operator fun invoke(s: String): String {
        val numStack: Stack<Int> = Stack()
        val strBuild: Stack<StringBuilder> = Stack()
        var str = StringBuilder()
        var num = 0
        for (c in s.toCharArray()) {
            when (c) {
                in '0'..'9' -> {
                    num = num * 10 + c.code - '0'.code
                }

                '[' -> {
                    strBuild.push(str)
                    str = StringBuilder()
                    numStack.push(num)
                    num = 0
                }

                ']' -> {
                    val temp = str
                    str = strBuild.pop()
                    var count: Int = numStack.pop()
                    while (count-- > 0) {
                        str.append(temp)
                    }
                }

                else -> {
                    str.append(c)
                }
            }
        }
        return str.toString()
    }
}

class DecodeStringRecursive : DecodeString {
    override operator fun invoke(s: String): String {
        val queue: Deque<Char> = LinkedList()
        for (c in s.toCharArray()) {
            queue.offer(c)
        }
        return helper(queue)
    }

    fun helper(queue: Deque<Char>): String {
        val sb = java.lang.StringBuilder()
        var num = 0
        while (queue.isNotEmpty()) {
            val c: Char = queue.poll()
            when {
                Character.isDigit(c) -> {
                    num = num * 10 + c.code - '0'.code
                }

                c == '[' -> {
                    val sub = helper(queue)
                    for (i in 0 until num) sb.append(sub)
                    num = 0
                }

                c == ']' -> {
                    break
                }

                else -> {
                    sb.append(c)
                }
            }
        }
        return sb.toString()
    }
}
