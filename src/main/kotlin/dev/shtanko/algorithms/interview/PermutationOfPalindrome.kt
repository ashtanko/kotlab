package dev.shtanko.algorithms.interview

fun String.isPermutationOfPalindrome(): Boolean {
    val unmatchedCharacters = HashSet<String>()
    for (c in this) {
        val character = c.toString()
        if (!unmatchedCharacters.contains(character)) {
            unmatchedCharacters.add(character)
        } else {
            unmatchedCharacters.remove(character)
        }
    }

    return unmatchedCharacters.size <= 1
}
