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

import java.util.LinkedList
import java.util.Queue

/**
 * 1215. Stepping Numbers
 * https://leetcode.com/problems/stepping-numbers/
 */
interface SteppingNumbers {
    fun countSteppingNumbers(low: Int, high: Int): List<Int>
}

class SteppingNumbersBFS : SteppingNumbers {
    override fun countSteppingNumbers(low: Int, high: Int): List<Int> {
        val res = ArrayList<Int>()
        if (low > high) return res

        val queue: Queue<Int> = LinkedList()
        for (i in 1..9) queue.add(i)

        if (low == 0) res.add(0)
        while (!queue.isEmpty()) {
            val p: Int = queue.poll()
            if (p < high) {
                val last = p % 10
                if (last > 0) queue.add(p * 10 + last - 1)
                if (last < 9) queue.add(p * 10 + last + 1)
            }
            if (p in low..high) {
                res.add(p)
            }
        }
        return res
    }
}
