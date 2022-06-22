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

package dev.shtanko.di.manual

/*
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

internal interface ElectricGenerator {
    @OptIn(ExperimentalTime::class)
    fun generate(duration: Duration): Electricity

    fun tankCapacity(): Double
}

internal interface PetrolGenerator : ElectricGenerator

internal interface DieselGenerator : ElectricGenerator

internal class PetrolGenerator1(private val fuel: Petrol) : PetrolGenerator {

    private var tankVolume = TANK_VOLUME // full tank by default

    @OptIn(ExperimentalTime::class)
    override fun generate(duration: Duration): Electricity {
        val joules = fuel.combustionEnergy().joule
        val durationMillis = CONSUMPTION_LITER_PER_HOUR.toDuration(DurationUnit.HOURS).inWholeMilliseconds
        val hours = TANK_VOLUME.div(CONSUMPTION_LITER_PER_HOUR).toDuration(DurationUnit.HOURS)
        val seconds = hours.inWholeSeconds
        val power: Watt = joules / seconds
        return Electricity(power)
    }

    override fun tankCapacity(): Double = tankVolume

    @OptIn(ExperimentalTime::class)
    fun ensureCapacity(duration: Duration) {
        if (isNeedMoreFuel(duration)) {
            grow()
        }
    }

    fun grow() {
        tankVolume += tankVolume / 2 // grow to half every time
    }

    companion object {
        // full tank for 10 hours
        private const val TANK_VOLUME = 100.0
        private const val CONSUMPTION_LITER_PER_HOUR = 10

        @OptIn(ExperimentalTime::class)
        fun consumptionMillis(): Long {
            return TANK_VOLUME.div(CONSUMPTION_LITER_PER_HOUR).toDuration(DurationUnit.HOURS).inWholeMilliseconds
        }

        @OptIn(ExperimentalTime::class)
        fun isNeedMoreFuel(duration: Duration): Boolean {
            return duration.inWholeMilliseconds > consumptionMillis()
        }
    }
}

internal class PetrolGenerator2(private val fuel: Petrol) : PetrolGenerator {

    @OptIn(ExperimentalTime::class)
    override fun generate(duration: Duration): Electricity {
        val joules = fuel.combustionEnergy().joule
        val hours = TANK_VOLUME / CONSUMPTION_LITER_PER_HOUR
        val seconds = hours * HOUR
        val power: Watt = joules / seconds
        return Electricity(power)
    }

    override fun tankCapacity(): Double {
        TODO("Not yet implemented")
    }

    companion object {
        private const val TANK_VOLUME = 300.0
        private const val CONSUMPTION_LITER_PER_HOUR = 1
    }
}
*/
