package dev.shtanko.algorithms.leetcode

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 */
fun Pair<String, String>.numJewelsInStones(): Int {
    var res = 0
    val setJ = hashSetOf<Char>()
    for (jewel in first) {
        setJ.add(jewel)
    }
    for (stone in second) {
        if (setJ.contains(stone)) {
            res++
        }
    }
    return res
}

fun Pair<String, String>.numJewelsInStonesRegex(): Int {
    return second.replace("[^$first]".toRegex(), "").length
}
