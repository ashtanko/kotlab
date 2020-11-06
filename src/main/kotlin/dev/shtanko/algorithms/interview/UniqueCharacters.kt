package dev.shtanko.algorithms.interview

fun uniqueCharacters(string: String): Boolean {
    val characters: MutableSet<Char> = HashSet()
    for (element in string) {
        if (characters.contains(element)) {
            return false
        }
        characters.add(element)
    }
    return true
}
