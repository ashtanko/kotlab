/*
 * Copyright 2023 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import kotlin.math.sqrt

/**
 * 319. Bulb Switcher
 * @see <a href="https://leetcode.com/problems/bulb-switcher/">Source</a>
 */
fun interface BulbSwitcher {
    fun bulbSwitch(n: Int): Int
}

class BulbSwitcherMath : BulbSwitcher {
    override fun bulbSwitch(n: Int): Int = sqrt(n.toDouble()).toInt()
}
