import java.util.*
import kotlin.math.abs

fun main() {
    val hm = hashMapOf<Int, Double>()

    for (i in 0 until 10_000) {
        hm[i] = abs(i).div(2.0)
    }

    println(hm.size)

    hm.remove(1)

    println(hm.size)

    val whm = WeakHashMap<Int, Double>()

    for (i in 0 until 10_000) {
        whm[i] = abs(i).div(2.0)
    }

    println(whm.size)
}