/*
 * Copyright 2021 Alexey Shtanko
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

import java.util.TreeMap

/**
 * 1859. Sorting the Sentence
 * https://leetcode.com/problems/sorting-the-sentence/
 */
fun sortSentence(s: String): String {
    val map = TreeMap<Int, String>()
    val str = s.split(" ").toTypedArray()
    for (st in str) {
        val len = st.length - 1
        val number = Character.getNumericValue(st[len])
        val snew = StringBuilder()
        snew.append(st)
        snew.replace(len, len + 1, " ")
        val string = snew.toString()
        map[number] = string
    }
    val string = StringBuilder()
    for (n in map.keys) {
        string.append(map[n])
    }
    val i = string.length
    string.deleteCharAt(i - 1)
    return string.toString()
}
