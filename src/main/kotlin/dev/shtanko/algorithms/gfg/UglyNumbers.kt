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

package dev.shtanko.algorithms.gfg

/**
 * Ugly Numbers
 * https://www.geeksforgeeks.org/ugly-numbers/
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 * Given a number n, the task is to find n’th Ugly number.
 */
interface UglyNumbers {
    fun perform(n: Int): Int
}

class UglyNumbersBruteForce : UglyNumbers {
    override fun perform(n: Int): Int {
        TODO("Not yet implemented")
    }
}
