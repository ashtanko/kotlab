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

package dev.shtanko.auto.value

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AnimalTest {

    @Test
    fun `animal class auto value test`() {
        val dog = Animal.create("dog", 4)
        assertEquals("dog", dog?.name())
        assertEquals(4, dog?.numberOfLegs())

        assertTrue(Animal.create("dog", 4)!! == dog)
        assertFalse(Animal.create("cat", 4)!! == dog)
        assertFalse(Animal.create("dog", 2)!! == dog)

        assertEquals("Animal{name=dog, numberOfLegs=4}", dog.toString())
    }
}
