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

package dev.shtanko.di.manual

internal fun main() {
    val heater: Heater = ElectricHeater()
    val pump: Pump = Thermosiphon()

    val fuel: Petrol = PremiumUnleadedPetrol()
    val generator: ElectricGenerator = PetrolGenerator2(fuel)

    println(generator.generate().power)

    val coffee = CoffeeMaker(heater, pump).makeCoffee()
    println(coffee)
}
