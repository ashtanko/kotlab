/*
 * Copyright 2023 Oleksii Shtanko
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

package dev.shtanko.algorithms.bitwise

import dev.shtanko.algorithms.HALF
import dev.shtanko.algorithms.THREE_HALVES

// responsible for the fast approximation
private const val MAGIC_NUMBER = 0x5f3759df

fun fastInverseSquareRoot(number: Float): Float {
    var i: Long
    val x2 = number.times(HALF)
    var y = number
    i = java.lang.Float.floatToIntBits(y).toLong()
    i = MAGIC_NUMBER - i.shr(1)
    y = java.lang.Float.intBitsToFloat(i.toInt())
    y *= THREE_HALVES - x2.times(y).times(y)
    return y
}
