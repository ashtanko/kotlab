/*
 * Copyright 2021 Alexey Shtanko
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

package dev.shtanko.concurrency.coroutines.mutex

import dev.shtanko.concurrency.TestBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CounterTest : TestBase() {

    private var counter: Counter = Counter()

    @Test
    fun test() = runTest {

        assertThat(counter).isNotNull

        withContext(Dispatchers.Default) {
            massiveRun {
                counter.inc()
            }
        }

        withContext(Dispatchers.Default) {
            massiveRun {
                counter.dec()
            }
        }
        assertThat(counter.value()).isEqualTo(0)
    }
}