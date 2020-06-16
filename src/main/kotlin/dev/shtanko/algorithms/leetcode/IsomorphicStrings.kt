package dev.shtanko.algorithms.leetcode

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 */
fun Pair<String, String>.isIsomorphic(): Boolean {
    if (first.length <= 1) return true
    val map = hashMapOf<Char, Char>()
    for (i in first.indices) {
        val a = first[i]
        val b = second[i]

        if (map.containsKey(a)) {
            if (map[a] == b) {
                continue
            } else {
                return false
            }
        } else {
            if (!map.containsValue(b)) {
                map[a] = b
            } else {
                return false
            }
        }
    }
    return true
}
