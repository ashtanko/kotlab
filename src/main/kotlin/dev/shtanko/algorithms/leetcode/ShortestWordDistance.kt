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
