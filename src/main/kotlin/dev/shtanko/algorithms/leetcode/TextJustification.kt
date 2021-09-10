package dev.shtanko.algorithms.leetcode

import kotlin.math.max

/**
 * 68. Text Justification
 * @link https://leetcode.com/problems/text-justification/
 */
interface TextJustification {
    fun perform(words: Array<String>, maxWidth: Int): List<String>
}

class TextJustificationImpl : TextJustification {

    override fun perform(words: Array<String>, maxWidth: Int): List<String> {
        var curr = 0
        val out: MutableList<String> = ArrayList()
        while (curr < words.size) {
            var currLineLen = 0
            val start = curr
            var end = curr

            // Determine start and end positions
            while (end < words.size && currLineLen + words[end].length + (end - start) <= maxWidth) {
                currLineLen += words[end].length
                end++
            }
            currLineLen += end - start - 1
            val spaces = IntArray(end - start) { 1 }
            spaces[spaces.size - 1] = 0 // Last word does not appended with space unless it is at last line
            if (currLineLen < maxWidth) {
                if (end == words.size) {
                    // Add spaces to end at last line
                    spaces[spaces.size - 1] += maxWidth - currLineLen
                } else {
                    // Iterate through spaces until all spaces consumed
                    val arrSize = max(spaces.size - 1, 1)
                    val spaceNeeded = maxWidth - currLineLen
                    var i = 0
                    var j = 0
                    while (i < spaceNeeded) {
                        spaces[j]++
                        i++
                        j = (j + 1) % arrSize
                    }
                }
            }
            val sb = StringBuilder()
            for (i in start until end) {
                sb.append(words[i])

                // Add spaces from spaces array
                for (j in 0 until spaces[i - start]) sb.append(" ")
            }
            out.add(sb.toString())
            curr = end
        }
        return out
    }
}
