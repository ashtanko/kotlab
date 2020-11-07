package dev.shtanko.algorithms.leetcode

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 */
interface NumJewelsInStonesStrategy {
    fun perform(a: String, b: String): Int
}

class NumJewelsInStonesMap : NumJewelsInStonesStrategy {
    override fun perform(a: String, b: String): Int {
        var res = 0
        val setJ = hashSetOf<Char>()
        for (jewel in a) {
            setJ.add(jewel)
        }
        for (stone in b) {
            if (setJ.contains(stone)) {
                res++
            }
        }
        return res
    }
}

class NumJewelsInStonesRegex : NumJewelsInStonesStrategy {
    override fun perform(a: String, b: String): Int {
        return b.replace("[^$a]".toRegex(), "").length
    }
}
