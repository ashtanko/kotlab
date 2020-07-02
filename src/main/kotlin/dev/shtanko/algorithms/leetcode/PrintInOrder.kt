package dev.shtanko.algorithms.leetcode

import java.util.concurrent.Semaphore

class PrintInOrder {

    private val run2 = Semaphore(0)
    private val run3 = Semaphore(0)

    @Throws(InterruptedException::class)
    fun first(printFirst: Runnable) {
        printFirst.run()
        run2.release()
    }

    @Throws(InterruptedException::class)
    fun second(printSecond: Runnable) {
        run2.acquire()
        printSecond.run()
        run3.release()
    }

    @Throws(InterruptedException::class)
    fun third(printThird: Runnable) {
        run3.acquire()
        printThird.run()
    }
}
