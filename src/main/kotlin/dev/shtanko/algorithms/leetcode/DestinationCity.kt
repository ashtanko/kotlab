/*
 * Copyright 2020 Oleksii Shtanko
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

interface DestinationCityStrategy {
    fun perform(paths: List<List<String>>): String
}

class DestinationCitySet : DestinationCityStrategy {
    override fun perform(paths: List<List<String>>): String {
        val set: MutableSet<String?> = HashSet()
        for (l in paths) set.add(l[1])
        for (l in paths) set.remove(l[0])
        return if (set.isEmpty()) "" else set.iterator().next() ?: ""
    }
}

class DestinationCityHashMap : DestinationCityStrategy {
    override fun perform(paths: List<List<String>>): String {
        val map: MutableMap<String?, String?> = HashMap()
        for (path in paths) {
            map[path[0]] = path[1]
        }
        for (city in map.values) {
            if (!map.containsKey(city)) {
                return city ?: ""
            }
        }
        return ""
    }
}
