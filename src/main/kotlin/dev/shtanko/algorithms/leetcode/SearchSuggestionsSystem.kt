/*
 * Copyright 2021 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import kotlin.math.abs
import kotlin.math.min

/**
 * Search Suggestions System
 */
interface SearchSuggestionsSystem {
    operator fun invoke(products: Array<String>, searchWord: String): List<List<String>>
}

/**
 * Approach 1: Binary Search
 * Time complexity : O(n log(n))+O(m log(n)).
 * Space complexity : Varies between O(1)
 */
class SSSBinarySearch : SearchSuggestionsSystem {
    override operator fun invoke(products: Array<String>, searchWord: String): List<List<String>> {
        products.sort()
        val result: MutableList<MutableList<String>> = ArrayList()
        var start: Int
        var bsStart = 0
        val n: Int = products.size
        var prefix = String()
        for (c in searchWord.toCharArray()) {
            prefix += c

            // Get the starting index of word starting with `prefix`.
            start = lowerBound(products, bsStart, prefix)

            // Add empty vector to result.
            result.add(ArrayList())

            // Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (i in start until min(start + 3, n)) {
                if (products[i].length < prefix.length || products[i].substring(0, prefix.length) != prefix) break
                result[result.size - 1].add(products[i])
            }

            // Reduce the size of elements to binary search on since we know
            bsStart = abs(start)
        }
        return result
    }

    private fun lowerBound(products: Array<String>, start: Int, word: String?): Int {
        var i = start
        var j = products.size
        var mid: Int
        while (i < j) {
            mid = (i + j) / 2
            if (products[mid] >= word!!) j = mid else i = mid + 1
        }
        return i
    }
}

/**
 * Approach 2: Trie + DFS
 * Time complexity : O(M).
 * Space complexity : O(26n)=O(n).
 */
class SSSTrie : SearchSuggestionsSystem {
    override operator fun invoke(products: Array<String>, searchWord: String): List<List<String>> {
        val result: MutableList<List<String>> = ArrayList()
        val roots: MutableList<TrieNode> = ArrayList()
        // Time O(m * l): where m == products array length and  l == max length of products
        // Space O(m * l)
        var root: TrieNode? = buildTrie(products)

        // O(L): where L == searchWord length
        // Space O(L)
        for (element in searchWord) {
            root = root?.next?.get(element - 'a')
            if (root == null) break
            roots.add(root)
        }

        // O(L * m * l): where L == searchWord length
        //             : m == products array length
        //             : l == max length of products
        // Space O(m * l)
        for (child in roots) {
            val subList: MutableList<String> = ArrayList()
            search(child, subList)
            result.add(subList)
        }

        // O(L): where L == searchWord length
        while (result.size < searchWord.length) result.add(ArrayList())
        return result
    }

    private fun search(root: TrieNode, res: MutableList<String>) {
        root.word?.let {
            res.add(it)
        }
        if (res.size >= 3) return
        for (child in root.next) {
            if (child != null) {
                search(child, res)
                if (res.size >= 3) return
            }
        }
    }

    private fun buildTrie(words: Array<String>): TrieNode {
        val root = TrieNode()
        for (word in words) {
            var p: TrieNode? = root
            for (ch in word.toCharArray()) {
                val index = ch - 'a'
                p?.let {
                    if (it.next[index] == null) it.next[index] = TrieNode()
                }
                p = p?.next?.get(index)
            }
            p?.word = word
        }
        return root
    }

    class TrieNode {
        var word: String? = null
        var next = arrayOfNulls<TrieNode>(ALPHABET_LETTERS_COUNT)
    }
}
