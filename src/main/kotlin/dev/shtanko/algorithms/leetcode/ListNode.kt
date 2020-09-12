package dev.shtanko.algorithms.leetcode

data class ListNode(
    val value: Int,
    var next: ListNode? = null
) {
    fun prettyPrinted(): String {
        val sb = StringBuilder()
        var node: ListNode? = this
        while (node?.next != null) {
            sb.append("${node.value}->")
            node = node.next
        }
        if (node != null) {
            sb.append(node.value)
        } else {
            sb.append("Empty LinkedList")
        }
        return sb.toString()
    }

    fun prettyPrint() {
        println(prettyPrinted())
    }
}
