/*
 * Copyright 2023 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.twopointers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidPalindromeTest {

    @Test
    fun `test valid palindrome with alphanumeric characters`() {
        val input = "A man, a plan, a canal: Panama"
        val isValid = isPalindrome(input)

        assertEquals(true, isValid)
    }

    @Test
    fun `test invalid palindrome with alphanumeric characters`() {
        val input = "race a car"
        val isValid = isPalindrome(input)

        assertEquals(false, isValid)
    }

    @Test
    fun `test valid palindrome with special characters and spaces`() {
        val input = "Was it a car or a cat I saw?"
        val isValid = isPalindrome(input)

        assertEquals(true, isValid)
    }

    @Test
    fun `test empty string`() {
        val input = ""
        val isValid = isPalindrome(input)

        assertEquals(true, isValid)
    }
}
