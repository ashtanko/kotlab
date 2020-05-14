package linked_list

import java.util.*

fun main() {
    val elements: LinkedList<Int> = LinkedList()
    elements.addAll(
        listOf(
            1, 5, -9, 5, -8, -3, -1, -2, 31, 67
        )
    )

    val positiveOnes = LinkedList<Int>()
    val negativeOnes = LinkedList<Int>()

    val i = elements.iterator()
    while (i.hasNext()) {
        val elem = i.next()
        if (elem < 0) {
            negativeOnes.add(elem)
        } else {
            positiveOnes.add(elem)
        }
    }


    println(negativeOnes)
    println(positiveOnes)

}
