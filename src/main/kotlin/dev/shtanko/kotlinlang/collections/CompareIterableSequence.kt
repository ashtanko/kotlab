/*
 * Copyright 2020 Alexey Shtanko
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

package dev.shtanko.kotlinlang.collections

import dev.shtanko.algorithms.extensions.isEven

fun main() {

    val smallList = 0..2
    val smallSequence = smallList.asSequence()

    getFirstFromList(smallList)
    println()
    getFirstFromSequence(smallSequence)
}

fun getFirstFromList(list: IntRange) {
    list
        .map { println("map $it"); it * 2 }
        .filter { println("filter $it"); it.isEven }
        .take(1)
        .forEach { println("list $it") }
}

fun getFirstFromSequence(sequence: Sequence<Int>) {
    sequence
        .map { println("map $it"); it * 2 }
        .filter { println("filter $it"); it.isEven }
        .take(1)
        .forEach { println("sequence $it") }
}
