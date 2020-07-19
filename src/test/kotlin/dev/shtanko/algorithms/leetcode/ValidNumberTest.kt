package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidNumberTest {

    @Test
    fun `regex test`() {
        assertTrue("0".isNumberRegex())
        assertTrue(" 0.1 ".isNumberRegex())
        assertFalse("abc".isNumberRegex())
        assertFalse("1 a".isNumberRegex())
        assertTrue("2e10".isNumberRegex())
        assertTrue(" -90e3   ".isNumberRegex())
        assertFalse(" 1e".isNumberRegex())
        assertFalse("e3".isNumberRegex())
        assertTrue(" 6e-1".isNumberRegex())
        assertFalse(" 99e2.5 ".isNumberRegex())
        assertTrue("53.5e93".isNumberRegex())
        assertFalse(" --6 ".isNumberRegex())
        assertFalse("-+3".isNumberRegex())
        assertFalse("95a54e53".isNumberRegex())
    }

    @Test
    fun `simple test`() {
        assertTrue("0".isNumber())
        assertTrue(" 0.1 ".isNumber())
        assertFalse("abc".isNumber())
        assertFalse("1 a".isNumber())
        assertTrue("2e10".isNumber())
        assertTrue(" -90e3   ".isNumber())
        assertFalse(" 1e".isNumber())
        assertFalse("e3".isNumber())
        assertTrue(" 6e-1".isNumber())
        assertFalse(" 99e2.5 ".isNumber())
        assertTrue("53.5e93".isNumber())
        assertFalse(" --6 ".isNumber())
        assertFalse("-+3".isNumber())
        assertFalse("95a54e53".isNumber())
    }
}
