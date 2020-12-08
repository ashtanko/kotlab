package dev.shtanko.algorithms.leetcode

/**
 * Time complexity: O(N).
 * Space complexity: O(1).
 */
class ReverseWordsInString2 {
    fun perform(s: CharArray) {
        // reverse the whole string
        reverse(s, 0, s.size - 1)

        // reverse each word
        reverseEachWord(s)
    }

    fun reverse(s: CharArray, left: Int, right: Int) {
        var l = left
        var r = right
        while (l < r) {
            val tmp = s[l]
            s[l++] = s[r]
            s[r--] = tmp
        }
    }

    fun reverseEachWord(s: CharArray) {
        val n = s.size
        var start = 0
        var end = 0
        while (start < n) {
            // go to the end of the word
            while (end < n && s[end] != ' ') {
                end++
            }
            // reverse the word
            reverse(s, start, end - 1)
            // move to the next word
            start = end + 1
            end++
        }
    }
}
