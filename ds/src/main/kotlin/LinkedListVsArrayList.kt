import java.util.*
import kotlin.collections.ArrayList

/**
 * Difference between linked list and array list
 */
fun main() {

    //---------- linked list ----------------
    val l = LinkedList<String?>()
    l.add("1")
    l.add(null)
    l.add(null)

    println("-------------linked list--------------")
    for (entry in l) {
        println("$entry")
    }

//    println("-------------linked list insert a lot of data--------------")
//    l.clear()
//    println("start: ${System.currentTimeMillis()}")
//    for (i in 0 until 10_000_000) {
//        l.add("${i * 2}")
//    }
//    println("added: ${System.currentTimeMillis()}")
//    for (i in 0 until 1000_000) {
//        l[i]
//    }
    //println("${l[20_0000]}")
    println("found: ${System.currentTimeMillis()}")

    val a = ArrayList<String?>()
    a.add("1")
    a.add(null)
    a.add(null)

    println("-------------array list--------------")
    for (entry in a) {
        println("$entry")
    }

    println("-------------array list insert a lot of data--------------")
    a.clear()
    println("start: ${System.currentTimeMillis()}")
    for (i in 0 until 10_000_000) {
        a.add("${i * 2}")
    }
    println("added: ${System.currentTimeMillis()}")
    for (i in 0 until 1000_000) {
        a.removeAt(i)
    }

}