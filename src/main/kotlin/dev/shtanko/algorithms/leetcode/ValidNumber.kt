package dev.shtanko.algorithms.leetcode

import java.util.Locale

fun String.isNumberRegex(): Boolean {
    return trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?".toRegex())
}

fun String.isNumber(): Boolean {
    var s = this
    s = s.toLowerCase(Locale.ROOT).trim { it <= ' ' }
    var dotSeen = false
    var eSeen = false
    var numberBeforeE = false
    var numberAfterE = false
    for (i in s.indices) {
        val cur = s[i]
        if (cur in '0'..'9') {
            if (!eSeen) {
                numberBeforeE = true
            } else {
                numberAfterE = true
            }
        } else if (cur == '-' || cur == '+') {
            if (i != 0 && s[i - 1] != 'e') return false
        } else if (cur == '.') {
            if (eSeen || dotSeen) return false
            dotSeen = true
        } else if (cur == 'e') {
            if (eSeen) return false
            eSeen = true
        } else { // invalid chars
            return false
        }
    }
    return if (eSeen) numberBeforeE && numberAfterE else numberBeforeE
}
