/*
 * Copyright 2022 Oleksii Shtanko
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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DinnerPlateStacksTest {

    @Test
    fun `dinner plate stacks test`() {
        val obj = DinnerPlates(2)
        obj.push(1)
        obj.push(2)
        obj.push(3)
        obj.push(4)
        obj.push(5)

        assertThat(obj.popAtStack(0)).isEqualTo(2)
        obj.push(20)
        obj.push(21)
        assertThat(obj.popAtStack(0)).isEqualTo(20)
        assertThat(obj.popAtStack(2)).isEqualTo(21)
        assertThat(obj.pop()).isEqualTo(5)
        assertThat(obj.pop()).isEqualTo(4)
        assertThat(obj.pop()).isEqualTo(3)
        assertThat(obj.pop()).isEqualTo(1)
        assertThat(obj.pop()).isEqualTo(-1)
    }

    @Test
    fun `dinner plate stacks tree test`() {
        val obj = DinnerPlatesTree(2)
        obj.push(1)
        obj.push(2)
        obj.push(3)
        obj.push(4)
        obj.push(5)

        assertThat(obj.popAtStack(0)).isEqualTo(2)
        obj.push(20)
        obj.push(21)
        assertThat(obj.popAtStack(0)).isEqualTo(20)
        assertThat(obj.popAtStack(2)).isEqualTo(21)
        assertThat(obj.pop()).isEqualTo(5)
        assertThat(obj.pop()).isEqualTo(4)
        assertThat(obj.pop()).isEqualTo(3)
        assertThat(obj.pop()).isEqualTo(1)
        assertThat(obj.pop()).isEqualTo(-1)
    }
}
