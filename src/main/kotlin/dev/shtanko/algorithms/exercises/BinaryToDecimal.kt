package dev.shtanko.algorithms.exercises

import dev.shtanko.algorithms.extensions.isBinary
import java.util.TreeMap

class BinaryToDecimal {

    fun perform(binary: String): Int {
        val powers = getPowers()
        val map: MutableMap<Int, Int> = TreeMap()

        val str = if (binary.isBinary()) binary else ""
        val st = str.reversed()
        val result = st.map { c ->
            Integer.parseInt("$c")
        }
        for (i in result.indices) {
            map[powers[i]] = result[i]
        }

        return map.filter {
            it.value == 1
        }.keys.sum()
    }
}
