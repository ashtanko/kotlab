package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.math.gcd
import java.util.HashMap

private const val SAME_LINE = 3

fun Array<IntArray>.maxPoints(): Int {
    if (size < SAME_LINE) return size
    var maxres = 0
    for (i in indices) {
        var same = 0
        var tempMax = 0
        val map = HashMap<String, Int>()
        for (j in indices) {
            if (i != j) {
                val dx = this[i][0] - this[j][0]
                val dy = this[i][1] - this[j][1]
                if (dx == 0 && dy == 0) {
                    same++
                    continue
                }
                val gcd = (dx to dy).gcd()
                val key = (dx / gcd).toString() + "/" + dy / gcd
                map[key] = map.getOrDefault(key, 0) + 1
                tempMax = tempMax.coerceAtLeast(map[key]!!)
            }
        }
        maxres = maxres.coerceAtLeast(tempMax + same + 1)
    }
    return maxres
}
