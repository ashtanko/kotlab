/*
 * Copyright 2022 Alexey Shtanko
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

/**
 * 1944. Number of Visible People in a Queue
 * @link https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 */
interface CanSeePersonsCount {
    fun perform(heights: IntArray): IntArray
}

class CanSeePersonsCountStack : CanSeePersonsCount {
    override fun perform(heights: IntArray): IntArray {
        val n: Int = heights.size
        val ans = IntArray(n)
        val st: Stack<Int> = Stack()
        for (i in n - 1 downTo 0) {
            while (!st.empty() && heights[i] > st.peek()) {
                st.pop()
                ++ans[i]
            }
            if (!st.empty()) {
                ++ans[i]
            }
            st.push(heights[i])
        }
        return ans
    }
}