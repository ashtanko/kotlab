package dev.shtanko.algorithms.leetcode

private val MORSE = arrayOf(
    ".-",
    "-...",
    "-.-.",
    "-..",
    ".",
    "..-.",
    "--.",
    "....",
    "..",
    ".---",
    "-.-",
    ".-..",
    "--",
    "-.",
    "---",
    ".--.",
    "--.-",
    ".-.",
    "...",
    "-",
    "..-",
    "...-",
    ".--",
    "-..-",
    "-.--",
    "--.."
)

fun Array<String>.uniqueMorseRepresentations(): Int {
    val seen: MutableSet<String> = HashSet()
    for (word in this) {
        val code = StringBuilder()
        for (c in word.toCharArray()) {
            code.append(MORSE[c - 'a'])
        }
        seen.add(code.toString())
    }
    return seen.size
}
