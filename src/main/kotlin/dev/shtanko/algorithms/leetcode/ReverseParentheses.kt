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

import dev.shtanko.datastructures.Stack
import java.util.Deque
import java.util.LinkedList
import java.util.Queue

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * @see <a href="https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/">Source</a>
 */
fun interface ReverseParentheses {
    operator fun invoke(s: String): String
}

class ReverseParenthesesBF : ReverseParentheses {
    override operator fun invoke(s: String): String {
        val st: Stack<Char> = Stack()
        for (c in s.toCharArray()) {
            if (c == ')') {
                val p: Queue<Char> = LinkedList()
                while (st.isNotEmpty() && st.peek() != '(') p.add(st.poll())
                if (st.isNotEmpty()) st.poll()
                while (p.isNotEmpty()) st.push(p.remove())
            } else {
                st.push(c)
            }
        }
        val sb = StringBuilder()
        while (st.isNotEmpty()) sb.append(st.poll())

        return sb.reverse().toString()
    }
}

class ReverseParenthesesSort : ReverseParentheses {
    override operator fun invoke(s: String): String {
        val dq: Deque<StringBuilder> = LinkedList()
        dq.push(java.lang.StringBuilder()) // In case the first char is NOT '(', need an empty StringBuilder.

        for (c in s.toCharArray()) {
            when (c) {
                '(' -> { // need a new StringBuilder to save substring in brackets pair
                    dq.offer(java.lang.StringBuilder())
                }

                ')' -> { // found a matched brackets pair and reverse the substring between them.
                    val end = dq.pollLast()
                    dq.peekLast().append(end.reverse())
                }

                else -> { // append the char to the last StringBuilder.
                    dq.peekLast().append(c)
                }
            }
        }
        return dq.pollLast().toString()
    }
}
