/*
 * Copyright 2020 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import java.util.HashMap

fun Array<String>.subdomainVisits(): List<String> {
    val result: MutableList<String> = ArrayList()
    val map: MutableMap<String, Int> =
        HashMap() // key: subdomain, value: frequency
    val resultStringBuilder = StringBuilder()
    for (cpDomain in this) {
        val indexSpace = cpDomain.indexOf(' ')
        val numClicks = cpDomain.substring(0, indexSpace).toInt()
        val domain = cpDomain.substring(indexSpace + 1)
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
