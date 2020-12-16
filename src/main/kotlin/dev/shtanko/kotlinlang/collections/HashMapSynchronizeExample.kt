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

package dev.shtanko.kotlinlang.collections

import java.util.Collections

fun main() {
    val hashmap = HashMap<Int, String>()

    hashmap[0] = "A"
    hashmap[1] = "B"
    hashmap[2] = "C"

    val map = Collections.synchronizedMap(hashmap)
    val set = map.entries
    synchronized(map) {
        val i = set.iterator()
        while (i.hasNext()) {
            val pair = i.next()
            println("${pair.key} ${pair.value}")
        }
    }
}
