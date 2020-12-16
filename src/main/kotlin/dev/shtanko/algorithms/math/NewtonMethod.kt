/*
 * Copyright 2020 Alexey Shtanko
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

package dev.shtanko.algorithms.math

import kotlin.math.abs

private const val EPSILON = 1e-15

/**
 * Compute the square root using Newton's method
 */
fun sqrt(c: Int, e: Double = EPSILON): Double {
    return sqrt(c.toDouble(), e)
}

fun sqrt(c: Double, e: Double = EPSILON): Double {
    if (c < 0) return Double.NaN
    var t = c
    while (abs(t - c / t) > e * t)
        t = (c / t + t) / 2.0
    return t
}
