package dev.shtanko.algorithms.exercises

import java.util.TreeMap

class DecimalToBinary {
    fun perform(n: Int): String {
        val powers: MutableMap<Int, Int> = TreeMap()
        val list = MaxPowerOfTwo().decompose(n)
        for (power in getPowers()) {
            if (power > n) break
            powers[power] = if (list.contains(power)) 1 else 0
        }
        return powers.map {
            it.value
        }.reversed().joinToString("")
    }
}
