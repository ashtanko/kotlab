package dev.shtanko.algorithms.leetcode

interface DestinationCityStrategy {
    fun perform(paths: List<List<String>>): String
}

class DestinationCitySet : DestinationCityStrategy {
    override fun perform(paths: List<List<String>>): String {
        val set: MutableSet<String?> = HashSet()
        for (l in paths) set.add(l[1])
        for (l in paths) set.remove(l[0])
        return set.iterator().next() ?: ""
    }
}

class DestinationCityHashMap : DestinationCityStrategy {
    override fun perform(paths: List<List<String>>): String {
        if (paths.isEmpty()) return ""
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
