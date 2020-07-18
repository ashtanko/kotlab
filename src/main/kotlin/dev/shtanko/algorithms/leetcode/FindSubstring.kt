package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import java.util.HashMap

interface AbstractFindSubstring {
    fun perform(s: String, words: Array<String>): List<Int>
}

class FindSubstring : AbstractFindSubstring {
    override fun perform(s: String, words: Array<String>): List<Int> {
        val list: MutableList<Int> = ArrayList()
        val n = words.size
        if (n == 0) {
            return list
        }
        val map: MutableMap<String, Int> = HashMap()
        for (word in words) {
            map[word] = map.getOrDefault(word, 0) + 1
        }
        val size = words[0].length
        val window = size * n
        for (i in 0 until size) {
            var start = i
            while (start + window <= s.length) {
                val sub = s.substring(start, start + window)
                val temp: MutableMap<String, Int> = HashMap()
                var j = n
                while (j > 0) {
                    val word = sub.substring(size * (j - 1), size * j)
                    val count = temp.getOrDefault(word, 0) + 1
                    if (count > map.getOrDefault(word, 0)) {
                        break
                    }
                    temp[word] = count
                    --j
                }
                if (j == 0) {
                    list.add(start)
                }
                start += size * j.coerceAtLeast(1)
            }
        }
        return list
    }
}
