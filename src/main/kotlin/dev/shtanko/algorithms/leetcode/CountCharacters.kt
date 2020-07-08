package dev.shtanko.algorithms.leetcode

private const val COUNT_CHARACTERS_COUNT = 26

fun Array<String>.countCharacters(chars: String): Int {
    val arr = IntArray(COUNT_CHARACTERS_COUNT)
    for (ch in chars.toCharArray()) {
        arr[ch - 'a']++
    }
    var ans = 0
    for (s in this) {
        val clone = arr.clone()
        for (i in s.indices) {
            clone[s[i] - 'a']--
            if (clone[s[i] - 'a'] < 0) {
                break
            }
            if (i == s.length - 1) {
                ans += s.length
            }
        }
    }
    return ans
}
