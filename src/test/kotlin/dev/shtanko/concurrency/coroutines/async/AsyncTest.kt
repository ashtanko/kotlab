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

package dev.shtanko.concurrency.coroutines.async

import dev.shtanko.concurrency.TestBase
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AsyncTest : TestBase() {

    @Test
    fun `test simple`() = runTest {
        expect(1)
        val job: Deferred<Int> = async {
            expect(3)
            42
        }
        expect(2)
        assertTrue(job.isActive)
        assertThat(job.await()).isEqualTo(42)
        assertTrue(job.isActive.not())
        expect(4)
        assertThat(job.await()).isEqualTo(42) // second await -- same result
        finish(5)
    }

    @Test
    fun `test undispatched`() = runTest {
        expect(1)
        val d: Deferred<Int> = async(start = CoroutineStart.UNDISPATCHED) {
            expect(2)
            42
        }
        expect(3)
        assertTrue(!d.isActive)
        assertEquals(d.await(), 42)
        finish(4)
    }

    @Test
    fun `starts the coroutine lazily`() = runTest {
        expect(1)
        val job = async(start = CoroutineStart.LAZY) {
            expect(3)
            42
        }
        expect(2)
        assertTrue(!job.isActive && !job.isCompleted)
        assertEquals(job.await(), 42)
        assertTrue(!job.isActive && job.isCompleted && !job.isCancelled)
        expect(4)
        assertEquals(job.await(), 42)
        expect(5)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun `atomically schedules the coroutine`() = runTest {
        expect(1)
        val job = async(start = CoroutineStart.ATOMIC) {
            expect(3)
            42
        }
        expect(2)
        assertTrue(job.isActive)
        assertFalse(job.isCompleted)
        assertEquals(job.await(), 42)
        expect(4)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun `immediately schedules the coroutine`() = runTest {
        expect(1)
        val job = async(start = CoroutineStart.DEFAULT) {
            expect(3)
            42
        }
        expect(2)
        assertTrue(job.isActive)
        assertFalse(job.isCompleted)
        assertEquals(job.await(), 42)
        expect(4)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun `start coroutine undispatched`() = runTest {
        expect(1)
        val job = async(start = CoroutineStart.UNDISPATCHED) {
            expect(2)
            42
        }
        expect(3)
        assertFalse(job.isActive)
        assertTrue(job.isCompleted)
        assertEquals(job.await(), 42)
        expect(4)
    }
}
