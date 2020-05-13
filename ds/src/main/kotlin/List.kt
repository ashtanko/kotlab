import java.util.*
import kotlin.collections.ArrayList

fun main() {

    //region list
    val arrayList = ArrayList<String>(20_000)

    val linkedList = LinkedList<String>()

    //endregion

    //region set
    val set: Set<String> = setOf("A", "A", "B")

    val hashSet: Set<String> = hashSetOf("A", "A", "B")

    val linkedHashSet: Set<String> = linkedSetOf("A", "A", "B")
    //endregion

    //region queue
    val queue: Queue<String> = LinkedList<String>()

    val deque: Deque<String> = LinkedList<String>()

    val priorityQueue: PriorityQueue<String> = PriorityQueue()
    //endregion

    //region synchronized
    val synchronizedArrayList = Collections.synchronizedList(arrayList)

    val synchronizedLinkedList = Collections.synchronizedList(linkedList)
    //endregion


}