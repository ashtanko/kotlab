package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import java.util.HashMap

fun Array<String>.subdomainVisits(): List<String> {
    val result: MutableList<String> = ArrayList()
    val map: MutableMap<String, Int> =
        HashMap() // key: subdomain, value: frequency
    val resultStringBuilder = StringBuilder()
    for (cpdomain in this) {
        val indexSpace = cpdomain.indexOf(' ')
        val numClicks = cpdomain.substring(0, indexSpace).toInt()
        val domain = cpdomain.substring(indexSpace + 1)
        resultStringBuilder.setLength(0)
        resultStringBuilder.append(domain)
        while (true) {
            map[resultStringBuilder.toString()] = map.getOrDefault(resultStringBuilder.toString(), 0) + numClicks
            val dotPosition = resultStringBuilder.indexOf(".")
            if (dotPosition == -1) break
            resultStringBuilder.delete(0, dotPosition + 1)
        }
    }
    for (domain in map.keys) result.add(map[domain].toString() + " " + domain)
    return result
}
