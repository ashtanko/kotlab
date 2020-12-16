package dev.shtanko.algorithms.leetcode

import java.util.Arrays

class BoldWordsInString {
    fun perform(words: Array<String>, s: String): String {
        val bold = BooleanArray(s.length + 1)
        for (w in words) {
            var start: Int = s.indexOf(w, 0)
            while (start != -1) {
                Arrays.fill(bold, start, start + w.length, true)
                start = s.indexOf(w, start + 1)
            }
        }
        val r = StringBuilder().append(if (bold[0]) "<b>" else "")
        for (i in 0 until bold.size - 1) {
            r.append(s[i])
            if (!bold[i] && bold[i + 1]) r.append("<b>") else if (bold[i] && !bold[i + 1]) r.append("</b>")
        }
        return r.toString()
    }
}
