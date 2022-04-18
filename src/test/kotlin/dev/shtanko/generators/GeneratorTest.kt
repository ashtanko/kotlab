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

package dev.shtanko.generators

import arrow.core.test.UnitSpec
import io.kotlintest.properties.Gen
import kotlin.math.max
import kotlin.math.min

class GeneratorTest : UnitSpec() {
    init {
        "can align lists with different lengths" {
            io.kotlintest.properties.forAll(Gen.nonEmptyList(Gen.bool()), Gen.nonEmptyList(Gen.bool())) { a, b ->
                a.align(b).size == max(a.size, b.size)
            }

            io.kotlintest.properties.forAll(Gen.nonEmptyList(Gen.bool()), Gen.nonEmptyList(Gen.bool())) { a, b ->
                a.align(b).all.take(min(a.size, b.size)).all {
                    it.isBoth
                }
            }
        }
    }
}
