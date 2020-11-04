package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class LinkedListTest {

    @Test
    fun `linked list test`() {
        assertTrue(test(intArrayOf(1, 1, 2, 4, 5, 8, 5), intArrayOf(1, 2, 4, 5, 8)))
        assertTrue(test(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `remove duplicates test`() {
        assertTrue(test(intArrayOf(0, 1, 2, 3), 0, 3))
        assertTrue(test(intArrayOf(0, 1, 2, 3), 1, 2))
        assertTrue(test(intArrayOf(0, 1, 2, 3), 2, 1))
        assertTrue(test(intArrayOf(0, 1, 2, 3), 3, 0))
    }

    @Test
    fun `delete current node value test`() {
        val list = LinkedList.fromArray(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8))
        val node = list.asSequence().find { e -> e.data == 3 }!!
        deleteCurrentNodeValue(node)

        val output = list.asSequence()
            .map { e -> e.data }
            .toList()
            .toTypedArray()
            .toIntArray()

        assertTrue(intArrayOf(1, 2, 4, 5, 6, 7, 8).contentEquals(output))
    }

    @Test
    fun `partition and check test`() {
        assertTrue(test(5, intArrayOf(3, 5, 8, 5, 10, 2, 1)))
        assertTrue(!check(5, intArrayOf(3, 5, 8, 5, 10, 2, 1)))
    }

    @Test
    fun `add to linked list test`() {
        assertTrue(test(intArrayOf(7, 1, 6), intArrayOf(5, 9, 2), intArrayOf(2, 1, 9)))
        assertTrue(test(intArrayOf(2, 7, 1, 6), intArrayOf(5, 9, 2), intArrayOf(7, 6, 4, 6)))
        assertTrue(test(intArrayOf(3, 2, 7, 1, 6), intArrayOf(5, 9, 2), intArrayOf(8, 1, 0, 2, 6)))
        assertTrue(test(intArrayOf(9, 7, 8), intArrayOf(6, 8, 5), intArrayOf(5, 6, 4, 1)))
    }

    @Test
    fun `is linked list palindrome test`() {
        assertTrue(test(intArrayOf(1, 2, 1)))
        assertTrue(!test(intArrayOf(1, 2, 3)))
        assertTrue(test(intArrayOf(1, 2, 2, 1)))
    }

    @Test
    fun `find first intersection test`() {
        testTail(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        testTail(intArrayOf(1, 2, 3, 9), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))

        assertTrue(
            findFirstIntersection(
                LinkedList.fromArray(intArrayOf(1, 2, 3, 4)),
                LinkedList.fromArray(intArrayOf(1, 2, 3, 4, 5))
            ) == null
        )
    }

    @Test
    fun `loop test`() {
        testInnerLoop()
        testNonInnerLoop()
        testLongInnerLoop()
    }

    private fun testLongInnerLoop() {
        val ints = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
        val list = LinkedList.fromArray(ints)
        val innerNode = list.asSequence().drop(3).first()

        list.getTailNode().next = innerNode

        require(detectLoop(list) == innerNode)
    }

    private fun testNonInnerLoop() {
        val ints = intArrayOf(1, 2, 3, 4, 5, 6)
        val list = LinkedList.fromArray(ints)

        require(detectLoop(list) == null)
    }

    private fun testInnerLoop() {
        val ints = intArrayOf(1, 2, 3, 4, 5, 6)
        val list = LinkedList.fromArray(ints)
        val innerNode = list.asSequence().drop(3).first()

        list.getTailNode().next = innerNode

        require(detectLoop(list) == innerNode)
    }

    private fun testTail(prefixA: IntArray, prefixB: IntArray, suffix: IntArray) {
        val prefixAList = LinkedList.fromArray(prefixA)
        val prefixBList = LinkedList.fromArray(prefixB)
        val suffixList = LinkedList.fromArray(suffix)

        prefixAList.getTailNode().next = suffixList.head
        prefixBList.getTailNode().next = suffixList.head

        val actualIntersection = findFirstIntersection(prefixAList, prefixBList)

        require(suffixList.head == actualIntersection)
    }

    private fun test(input: IntArray): Boolean = isPalindrome(LinkedList.fromArray(input))

    fun test(aDigits: IntArray, bDigits: IntArray, sumDigits: IntArray): Boolean {
        val a = LinkedList.fromArray(aDigits)
        val b = LinkedList.fromArray(bDigits)

        val actualSum = add(a, b).asArray()

        return actualSum.contentEquals(sumDigits)
    }

    private fun test(pivot: Int, list: IntArray): Boolean {
        val linkedList = LinkedList.fromArray(list)
        partition(pivot, linkedList)
        return check(pivot, linkedList.asArray())
    }

    private fun test(input: IntArray, expected: IntArray): Boolean {
        val linkedList = LinkedList.fromArray(input)
        removeDuplicates(linkedList)

        val output = linkedList.asArray()
        return expected.contentEquals(output)
    }

    private fun test(input: IntArray, k: Int, expected: Int): Boolean =
        getKthToLast(LinkedList.fromArray(input), k) == expected
}
