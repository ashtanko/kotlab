package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

class PrintInOrderTest {

    private val printInOrder = PrintInOrder()

    @Test
    @Throws(InterruptedException::class)
    fun `test print in order with concurrency`() {
        val service = Executors.newFixedThreadPool(3)
        val latch = CountDownLatch(3)

        service.execute {
            printInOrder.first(Runnable {
                print("first")
            })
            latch.countDown()
        }

        service.execute {
            printInOrder.second(Runnable {
                print("second")
            })
            latch.countDown()
        }

        service.execute {
            printInOrder.third(Runnable {
                print("third")
            })
            latch.countDown()
        }

        latch.await()
    }

    @Test
    @Throws(InterruptedException::class)
    fun `test print in order with concurrency 2`() {
        val service = Executors.newFixedThreadPool(3)
        val latch = CountDownLatch(3)

        service.execute {
            printInOrder.first(Runnable {
                print("first")
            })
            latch.countDown()
        }

        service.execute {
            printInOrder.third(Runnable {
                print("third")
            })
            latch.countDown()
        }

        service.execute {
            printInOrder.second(Runnable {
                print("second")
            })
            latch.countDown()
        }
        latch.await()
    }
}
