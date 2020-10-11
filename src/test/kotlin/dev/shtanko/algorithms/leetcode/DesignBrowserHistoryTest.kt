package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class DesignBrowserHistoryTest<out T : BrowserHistory>(private val history: T) {

    @Test
    fun `history test`() {
        history.visit("google.com")
        history.visit("facebook.com")
        history.visit("youtube.com")
        assertEquals("facebook.com", history.back(1))
        assertEquals("google.com", history.back(1))
        assertEquals("facebook.com", history.forward(1))
        history.visit("linkedin.com")
        assertEquals("linkedin.com", history.forward(2))
        assertEquals("google.com", history.back(2))
        assertEquals("leetcode.com", history.back(7))
    }
}

internal class BrowserHistoryListTest :
    DesignBrowserHistoryTest<BrowserHistoryList>(BrowserHistoryList("leetcode.com"))

internal class BrowserHistoryStackTest :
    DesignBrowserHistoryTest<BrowserHistoryStack>(BrowserHistoryStack("leetcode.com"))

internal class BrowserHistoryArrayTest :
    DesignBrowserHistoryTest<BrowserHistoryArray>(BrowserHistoryArray("leetcode.com"))
