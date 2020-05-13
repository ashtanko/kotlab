import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap
import kotlin.collections.LinkedHashSet

fun main() {
    val hm = HashMap<Int,Double>()
    val ihm = IdentityHashMap<Int,Double>()
    val whm = WeakHashMap<Int,Double>()
    val lhm = LinkedHashMap<Int,Double>()
    val lhs = LinkedHashSet<Int>()
    val chm = ConcurrentHashMap<Int, Double>()

    val pq = PriorityQueue<Int>()

    //Collections.synchronizedList()
}