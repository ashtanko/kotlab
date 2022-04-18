/*
 * Copyright 2020 Oleksii Shtanko
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

class LemonadeChange {

    fun perform(bills: IntArray): Boolean {
        var five = 0
        var ten = 0
        for (i in bills) {
            when {
                i == BILL_FIVE -> five++
                i == BILL_TEN -> {
                    five--
                    ten++
                }
                ten > 0 -> {
                    ten--
                    five--
                }
                else -> five -= BILL_THREE
            }
            if (five < 0) return false
        }
        return true
    }

    companion object {
        private const val BILL_FIVE = 5
        private const val BILL_THREE = 3
        private const val BILL_TEN = 10
    }
}
