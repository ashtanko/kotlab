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

package dev.shtanko.algorithms.extensions

/**
 * This function divides a by greatest divisible power of b
 */
fun Pair<Int, Int>.maxDivide(): Int {
    val (a, b) = this
    var a0 = a
    while (a0 % b == 0) a0 /= b
    return a0
}

fun Int.getUgly(): Int {
    var n = this
    prms.map {
        n = (n to it).maxDivide()
    }
    return if (n == 1) 1 else 0
}

/**
 * Function to check if a number is ugly or not
 */
fun Int.isUgly(): Boolean {
    var n = this
    prms.map {
        n = (n to it).maxDivide()
    }
    return n == 1
}

private val prms = listOf(2, 3, 5)
