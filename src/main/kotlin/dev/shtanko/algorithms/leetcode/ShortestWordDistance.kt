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

import kotlin.math.abs
import kotlin.math.min

interface ShortestWordDistanceStrategy {
    fun perform(words: Array<String>, word1: String, word2: String): Int
}

class ShortestWordDistanceBruteForce : ShortestWordDistanceStrategy {
    override fun perform(words: Array<String>, word1: String, word2: String): Int {
        var minDistance: Int = words.size
        for (i in words.indices) {
            if (words[i] == word1) {
                for (j in words.indices) {
                    if (words[j] == word2) {
                        minDistance = min(minDistance, abs(i - j))
                    }
                }
            }
        }
        return minDistance
    }
}

class ShortestWordDistanceOnePass : ShortestWordDistanceStrategy {
    override fun perform(words: Array<String>, word1: String, word2: String): Int {
        var i1 = -1
        var i2 = -1
        var minDistance: Int = words.size
        for (i in words.indices) {
            if (words[i] == word1) {
                i1 = i
            } else if (words[i] == word2) {
                i2 = i
            }
            if (i1 != -1 && i2 != -1) {
                minDistance = min(minDistance, abs(i1 - i2))
            }
        }
        return minDistance
    }
}
