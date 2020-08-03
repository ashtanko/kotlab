package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import kotlin.math.abs

fun String.reformat(): String {
    val str: MutableList<Char> = ArrayList()
    val nums: MutableList<Char> = ArrayList()
    for (c in this.toCharArray()) {
        if (Character.isDigit(c)) {
            nums.add(c)
        } else {
            str.add(c)
        }
    }

    val strLen = str.size
    val numLen = nums.size
    if (abs(strLen - numLen) >= 2) {
        return ""
    }
    return if (strLen < numLen) {
        printStr(nums, str)
    } else printStr(str, nums)
}

private fun printStr(
    l1: List<Char>,
    l2: List<Char>
): String {
    var idx = 0
    val sb = StringBuilder()
    while (idx < l2.size) {
        sb.append(l1[idx])
        sb.append(l2[idx++])
    }
    while (idx < l1.size) {
        sb.append(l1[idx++])
    }
    return sb.toString()
}
