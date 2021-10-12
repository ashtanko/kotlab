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

/**
 * 1215. Stepping Numbers
 * https://leetcode.com/problems/stepping-numbers/
 */
interface SteppingNumbers {
    fun countSteppingNumbers(low: Int, high: Int): List<Int>
}

class SteppingNumbersBFS : SteppingNumbers {
    override fun countSteppingNumbers(low: Int, high: Int): List<Int> {
        val list: MutableList<Int> = ArrayList()

        for (i in 0..9) {
            dfs(low, high, i.toLong(), list)
        }
        list.sort()
        return list
    }

    private fun dfs(low: Int, high: Int, cur: Long, list: MutableList<Int>) {
        if (cur in low..high) list.add(cur.toInt())
        if (cur == 0L || cur > high) return
        val last = cur % 10
        val inc = cur * 10 + last + 1
        val dec = cur * 10 + last - 1
        when (last) {
            0L -> dfs(low, high, inc, list)
            9L -> dfs(low, high, dec, list)
            else -> {
                dfs(low, high, inc, list)
                dfs(low, high, dec, list)
            }
        }
    }
}
