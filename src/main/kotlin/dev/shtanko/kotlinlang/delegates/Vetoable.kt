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

package dev.shtanko.kotlinlang.delegates

import kotlin.properties.Delegates.vetoable
import kotlin.reflect.KProperty

var name by vetoable("Jack") { _: KProperty<*>, _, newValue ->
    newValue.startsWith("J")
}

var max: Int by vetoable(0) { _, oldValue, newValue ->
    newValue > oldValue
}
