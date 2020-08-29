package dev.shtanko.concurrency.rx

import io.reactivex.rxjava3.core.Observable
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ObservableUnitTest {

    private var result: String = ""

    @Test
    fun `given string when just and subscribe then emits single item`() {
        val observable = Observable.just("Hello")
        observable.subscribe { str ->
            result = str
        }
        assertTrue(result == "Hello")
    }

    @Test
    fun `given array when from and subscribe then emits items`() {
        val letters = listOf("a", "b", "c", "d", "e", "f", "g")
        val observable = Observable.fromIterable(letters)
        observable.subscribe(
            {
                result += it
            },
            { obj: Throwable ->
                obj.printStackTrace()
            },
            {
                result += "_Complete"
            }
        )
        assertTrue(result == "abcdefg_Complete")
    }

    @Test
    fun `given Array when converts observable to blocking observable then return first element`() {
        val letters = listOf("a", "b", "c", "d", "e", "f", "g")
        val observable = Observable.fromIterable(letters)
        val blockingObservable: String = observable.blockingFirst()
        observable.subscribe(
            {
                result += it
            },
            { obj: Throwable ->
                obj.printStackTrace()
            },
            {
                result += "_Complete"
            }
        )
        assertTrue(result.first().toString() == blockingObservable)
    }

    @Test
    fun `given array when map and subscribe then return capital letters`() {
        val letters = listOf("a", "b", "c", "d", "e", "f", "g")
        Observable.fromIterable(letters).map {
            it.toUpperCase()
        }.subscribe { letter ->
            result += letter
        }
        assertTrue(result == "ABCDEFG")
    }

    @Test
    fun `given array when scan and subscribe then return the sum of all letters`() {
        val letters = listOf("a", "b", "c")
        Observable.fromIterable(letters)
            .scan(StringBuilder(), StringBuilder::append)
            .subscribe { total ->
                result += total.toString()
            }
        assertTrue(result == "aababc")
    }

    @Test
    fun `given array of numbers when group by then create two groups based on parity`() {
        val numbers = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val evens = mutableListOf("")
        val odds = mutableListOf("")
        Observable.fromIterable(numbers).groupBy {
            if (it % 2 == 0) "EVEN" else "ODD"
        }.subscribe { group ->
            group.subscribe { number ->
                if (group.key == "EVEN") {
                    evens[0] += "$number"
                } else {
                    odds[0] += "$number"
                }
            }
        }
        assertTrue(evens[0] == "0246810")
        assertTrue(odds[0] == "13579")
    }

    @Test
    fun `given array of numbers when filter then get all odd numbers`() {
        val numbers = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Observable.fromIterable(numbers).filter {
            it % 2 == 1
        }.subscribe {
            result += it
        }
        assertTrue(result == "13579")
    }

    @Test
    fun `given empty observable when default if empty then get default message`() {
        Observable.empty<String>().defaultIfEmpty("Observable is empty")
            .subscribe {
                result += it
            }
        assertTrue(result == "Observable is empty")
    }

    @Test
    fun `given observable from array when take while then get sum of numbers from condition`() {
        val numbers = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val sum = intArrayOf(0)
        Observable.fromIterable(numbers).takeWhile {
            it < 5
        }.subscribe {
            sum[0] += it
        }
        assertTrue(sum[0] == 10)
    }
}
