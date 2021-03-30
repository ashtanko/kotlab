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

internal interface ElectricGenerator {
    fun generate(): Electricity
}

internal interface PetrolGenerator : ElectricGenerator

internal interface DieselGenerator : ElectricGenerator

internal class PetrolGenerator1(private val fuel: Petrol) : PetrolGenerator {

    override fun generate(): Electricity {
        val joules = fuel.combustionEnergy().joule
        val hours = TANK_VOLUME / CONSUMPTION_LITER_PER_HOUR
        val seconds = hours * HOUR
        val power: Watt = joules / seconds
        return Electricity(power)
    }

    companion object {
        private const val TANK_VOLUME = 100.0
        private const val CONSUMPTION_LITER_PER_HOUR = 10
    }
}

internal class PetrolGenerator2(private val fuel: Petrol) : PetrolGenerator {

    override fun generate(): Electricity {
        val joules = fuel.combustionEnergy().joule
        val hours = TANK_VOLUME / CONSUMPTION_LITER_PER_HOUR
        val seconds = hours * HOUR
        val power: Watt = joules / seconds
        return Electricity(power)
    }

    companion object {
        private const val TANK_VOLUME = 300.0
        private const val CONSUMPTION_LITER_PER_HOUR = 1
    }
}
