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

package dev.shtanko.algorithms.leetcode

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */
fun Array<IntArray>.rotateImage() {

    for (i in this.indices) {
        for (j in i until this[0].size) {
            val tmp = this[i][j]
            this[i][j] = this[j][i]
            this[j][i] = tmp
        }
    }

    for (i in this.indices) {
        for (j in 0 until this.size / 2) {
            val tmp = this[i][j]
            this[i][j] = this[i][this.size - 1 - j]
            this[i][this.size - 1 - j] = tmp
        }
    }
}
