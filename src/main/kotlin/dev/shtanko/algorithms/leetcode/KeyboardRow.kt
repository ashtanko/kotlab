package dev.shtanko.algorithms.leetcode

import java.util.HashMap
import java.util.LinkedList
import java.util.Locale

fun Array<String>.findWords(): Array<String> {
    val strs = arrayOf("QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM")
    val map: MutableMap<Char, Int> = HashMap()
    for (i in strs.indices) {
        for (c in strs[i].toCharArray()) {
            map[c] = i // put <char, rowIndex> pair into the map
        }
    }
    val res: MutableList<String> = LinkedList()
    for (w in this) {
        if (w == "") continue
        var index = map[w.toUpperCase(Locale.ROOT)[0]]
        for (c in w.toUpperCase(Locale.ROOT).toCharArray()) {
            if (map[c] != index) {
                index = -1 // don't need a boolean flag.
                break
            }
        }
        if (index != -1) res.add(w) // if index != -1, this is a valid string
    }
    return res.toTypedArray()
}
