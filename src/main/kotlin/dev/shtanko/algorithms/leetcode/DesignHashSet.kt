package dev.shtanko.algorithms.leetcode

interface DesignHashSet {
    fun add(key: Int)
    fun remove(key: Int)
    fun contains(key: Int): Boolean
}

class DesignHashSetImpl : DesignHashSet {

    private var capacity = DEFAULT_CAPACITY
    private var cnt = 0
    var list = arrayOfNulls<DesignList>(capacity)

    init {
        for (i in 0 until capacity) {
            list[i] = DesignList()
        }
    }

    override fun add(key: Int) {
        if (contains(key)) return
        if (cnt < capacity) {
            addTail(key)
        } else { // rehash
            capacity *= 2
            val copy = list
            val newList = arrayOfNulls<DesignList>(capacity)
            for (i in 0 until capacity) {
                newList[i] = DesignList()
            }
            list = newList
            for (i in copy.indices) {
                var head: DesignListNode? = copy[i]!!.head
                while (head!!.next != null && head.next?.value != null) {
                    addTail(head.next?.value!!)
                    head = head.next
                }
            }
            addTail(key)
        }
        cnt++
    }

    override fun remove(key: Int) {
        if (!contains(key)) return
        cnt--
        val idx = key % capacity
        var head: DesignListNode? = list[idx]!!.head
        while (head!!.next != null && head.next?.value != null) {
            if (head.next?.value == key) {
                val next = head.next
                next!!.next?.pre = head
                head.next = next.next
                next.pre = null
                next.next = null
                break
            }
            head = head.next
        }
    }

    override fun contains(key: Int): Boolean {
        val idx = key % capacity
        var head: DesignListNode? = list[idx]!!.head
        while (head!!.next != null && head.next?.value != null) {
            if (head.next?.value == key) return true
            head = head.next
        }
        return false
    }

    private fun addTail(key: Int) {
        val idx = key % capacity
        val tail = list[idx]!!.tail
        val pre: DesignListNode = tail.pre ?: return
        val cur = DesignListNode(key)
        pre.next = cur
        cur.pre = pre
        cur.next = tail
        tail.pre = cur
    }

    companion object {
        private const val DEFAULT_CAPACITY = 32
    }
}

class DesignList {
    var head = DesignListNode()
    var tail = DesignListNode()

    init {
        head.next = tail
        tail.pre = head
    }
}

data class DesignListNode(var value: Int? = null) {
    var next: DesignListNode? = null
    var pre: DesignListNode? = null
}
