/*
 * Copyright 2024 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.codingbat

/**
 * Recursion-1 > bunnyEars2
 * https://codingbat.com/prob/p107330
 */
fun interface BunnyEars2 {
    operator fun invoke(bunnies: Int): Int
}

class BunnyEars2Iterative : BunnyEars2 {
    override fun invoke(bunnies: Int): Int {
        var res = 0
        repeat(bunnies) {
            res += if (it % 2 == 0) {
                2
            } else {
                3
            }
        }
        return res
    }
}

class BunnyEars2Recursive : BunnyEars2 {
    override fun invoke(bunnies: Int): Int {
        if (bunnies == 0) {
            return 0
        } else if (bunnies == 1) {
            return 2
        }
        return if (bunnies % 2 == 1) {
            2 + invoke(bunnies - 1)
        } else {
            3 + invoke(bunnies - 1)
        }
    }
}

class BunnyEars2Memo : BunnyEars2 {

    private val memo: MutableMap<Int, Int> = mutableMapOf()

    override fun invoke(bunnies: Int): Int {
        if (bunnies == 0) {
            return 0
        } else if (bunnies == 1) {
            return 2
        }

        // Check if the result for the current input is already memoized
        if (memo.containsKey(bunnies)) {
            return memo.getOrDefault(bunnies, 0)
        }

        // Recursive case for odd-numbered bunnies
        val result = if (bunnies % 2 == 1) {
            2 + invoke(bunnies - 1)
        } else {
            // Recursive case for even-numbered bunnies
            3 + invoke(bunnies - 1)
        }

        // Memoize the result before returning
        memo[bunnies] = result
        return result
    }
}
