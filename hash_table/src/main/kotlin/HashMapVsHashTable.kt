import java.util.Hashtable
import java.util.HashMap

/**
 * Differences between HashMap and HashTable
 */
fun main() {
    //----------hashtable -------------------------
    val ht = Hashtable<Int, String?>()
    ht[101] = " ajay"
    ht[101] = "Vijay"
    ht[102] = "Ravi"
    ht[103] = "Rahul"
    //ht[105] = null // hashtable doesn’t allow any null key or value.

    println("-------------Hash table--------------")
    for (entry in ht) {
        println("${entry.key} ${entry.value}")
    }

    //----------------hashmap--------------------------------
    val hm: HashMap<Int?, String?> = HashMap<Int?, String?>()

    hm[100] = "Amit"
    hm[104] = "Amit"  // hash map allows duplicate values
    hm[101] = "Vijay"
    hm[102] = "Rahul"
    hm[105] = null
    hm[106] = null
    hm[null] = null // hashMap allows one null key and multiple null values
    hm[null] = null

    println("-----------Hash map-----------")
    for (entry in hm) {
        println("${entry.key} ${entry.value}")
    }
}