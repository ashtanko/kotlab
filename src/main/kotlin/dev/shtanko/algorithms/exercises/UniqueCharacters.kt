package dev.shtanko.algorithms.exercises

import java.util.Collections
import java.util.stream.Collectors

/**
 * Implement an algorithm to determine if a string has all unique characters
 * What if you can not use additional data structures?
 */
interface UniqueCharacters {
    fun perform(str: String): Boolean
}

class UniqueCharactersSet : UniqueCharacters {
    override fun perform(str: String): Boolean {
        if (str.isBlank()) return false
        return str.length == str.toSet().size
    }
}

/**
 * Not use additional data structures
 */
class UniqueCharactersSort : UniqueCharacters {
    override fun perform(str: String): Boolean {
        if (str.isBlank()) return false
        val chars = str.toCharArray().sorted()
        for (i in 0 until chars.size - 1) {
            if (chars[i] != chars[i + 1]) {
                continue
            } else {
                return false
            }
        }
        return true
    }
}

class UniqueCharactersStream : UniqueCharacters {

    override fun perform(str: String): Boolean {
        if (str.isBlank()) return false

        return str.chars().filter { e ->
            val c = str.chars()
                .boxed()
                .collect(Collectors.toList())
            Collections.frequency(c, e) > 1
        }.count() <= 1
    }
}

class UniqueCharactersBruteForce : UniqueCharacters {
    override fun perform(str: String): Boolean {
        if (str.isBlank()) return false
        for (i in str.indices) {
            for (j in i + 1 until str.length) {
                if (str[i] == str[j]) {
                    return false
                }
            }
        }
        return true
    }
}
