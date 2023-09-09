/*
 * Copyright 2020 Oleksii Shtanko
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

package dev.shtanko.algorithms.leetcode

import java.math.BigInteger

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
fun interface AddBinaryStrategy {
    operator fun invoke(a: String, b: String): String
}

/**
 * Time complexity: O(max(N,M)), where N and M are lengths of the input strings a and b.
 * Space complexity: O(max(N,M)) to keep the answer.
 */
class AddBinaryBitByBitComputation : AddBinaryStrategy {
    override operator fun invoke(a: String, b: String): String {
        val sb = StringBuilder()
        var i: Int = a.length - 1
        var j: Int = b.length - 1
        var carry = 0
        while (i >= 0 || j >= 0) {
            var sum = carry
            if (j >= 0) sum += b[j--] - '0'
            if (i >= 0) sum += a[i--] - '0'
            sb.append(sum % 2)
            carry = sum / 2
        }
        if (carry != 0) sb.append(carry)
        return sb.reverse().toString()
    }
}

/**
 * Time complexity : O(N+M), where N and M are lengths of the input strings a and b.
 * Space complexity: O(max(N,M)) to keep the answer.
 */
class AddBinaryBitManipulation : AddBinaryStrategy {
    override operator fun invoke(a: String, b: String): String {
        if (a.isEmpty() || b.isEmpty()) return ""
        var x = BigInteger(a, 2)
        var y = BigInteger(b, 2)
        val zero = BigInteger("0", 2)
        var carry: BigInteger
        var answer: BigInteger
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y)
            carry = x.and(y).shiftLeft(1)
            x = answer
            y = carry
        }
        return x.toString(2)
    }
}
