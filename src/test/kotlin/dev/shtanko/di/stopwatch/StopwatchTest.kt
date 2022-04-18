/*
 * Copyright 2021 Oleksii Shtanko
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

package dev.shtanko.di.stopwatch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// TODO tmp solution
class StopwatchTest {

    @Test
    fun `start test`() {
        val s = Stopwatch(MockTimeSource())
        assertThat(s.start()).isEqualTo("Measure: 5")
    }

    private class MockTimeSource : TimeSource {
        override fun measure(): Int = 5
    }
}
