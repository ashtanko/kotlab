data class Node<T>(val value: T,
                   var leftNode: Node<T>?,
                   var rightNode: Node<T>?,
                   var depth: Int = 0) {
    fun link(left: Node<T>?, right: Node<T>?) = this.apply {
        linkLeft(left).linkRight(right)
    }

    fun linkLeft(left: Node<T>?) = this.apply { leftNode = left }

    fun linkRight(right: Node<T>?) = this.apply { rightNode = right }

    fun depth(value: Int) = this.apply { depth = value }

    /**
     * Nodes on the left are in yellow, and those on the right are blue.
     */
//    override fun toString(): String {
//        return StringBuffer().apply {
//            append("{${value.toString().green()}")
//            if (leftNode != null)
//                append(", ${leftNode.toString().yellow()}")
//            if (rightNode != null)
//                append(", ${rightNode.toString().blue()}}")
//        }.toString()
//    }
}

fun main() {

}