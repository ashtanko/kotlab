package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ImplementTrieTest {

    @Test
    internal fun `trie test`() {
        val trie = TrieImpl()
        trie.insert("apple")
        assertTrue(trie.search("apple"))
        assertFalse(trie.search("app"))
        assertTrue(trie.startsWith("app"))
        trie.insert("app")
        assertTrue(trie.search("app"))
    }

    @Test
    internal fun `empty string trie test`() {
        val trie = TrieImpl()
        trie.insert("")
        assertFalse(trie.search("app"))
    }

    @Test
    internal fun `empty trie test`() {
        val trie = TrieImpl()
        assertFalse(trie.search(""))
    }
}
