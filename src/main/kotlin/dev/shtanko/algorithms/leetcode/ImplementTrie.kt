package dev.shtanko.algorithms.leetcode

data class TrieNode(var isEnd: Boolean = false) {
    companion object {
        private const val R = 26
    }

    private val links: Array<TrieNode?> = Array(R) { null }

    fun containsKey(ch: Char): Boolean {
        return links[ch - 'a'] != null
    }

    fun get(ch: Char): TrieNode? {
        return links[ch - 'a']
    }

    fun put(ch: Char, node: TrieNode?) {
        links[ch - 'a'] = node
    }
}

internal interface Trie {
    fun insert(word: String)

    fun search(word: String): Boolean

    fun startsWith(prefix: String): Boolean
}

internal class TrieImpl : Trie {

    private val root = TrieNode()

    override fun insert(word: String) {
        var node: TrieNode? = root
        for (ch in word) {
            if (node?.containsKey(ch) != true) {
                node?.put(ch, TrieNode())
            }
            node = node?.get(ch)
        }
        node?.isEnd = true
    }

    override fun search(word: String): Boolean {
        val node = searchPrefix(word)
        return node != null && node.isEnd
    }

    override fun startsWith(prefix: String): Boolean {
        val node = searchPrefix(prefix)
        return node != null
    }

    private fun searchPrefix(word: String): TrieNode? {
        var node: TrieNode? = root
        for (ch in word) {
            if (node?.containsKey(ch) == true) {
                node = node.get(ch)
            } else {
                return null
            }
        }
        return node
    }
}
