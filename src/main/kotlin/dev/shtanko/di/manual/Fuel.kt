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

internal interface Fuel {
    fun combustionEnergy(): Energy
}

internal interface SolidFuel : Fuel

internal interface LiquidFuel : Fuel

internal interface FuelGas : Fuel

internal interface Petrol : LiquidFuel

internal interface Wood : SolidFuel

internal class PremiumUnleadedPetrol : Petrol {
    override fun combustionEnergy(): Energy {
        return Energy(CALORIFIC_VALUE * MEGAJOULE)
    }

    companion object {
        private const val CALORIFIC_VALUE = 46.0
    }
}

internal class GreenWood : Wood {
    override fun combustionEnergy(): Energy {
        return Energy(WOOD_CALORIFIC_VALUE * MEGAJOULE)
    }

    companion object {
        private const val WOOD_CALORIFIC_VALUE = 9.5
    }
}

internal class WoodPallet : Wood {
    override fun combustionEnergy(): Energy {
        return Energy(WOOD_CALORIFIC_VALUE * MEGAJOULE)
    }

    companion object {
        private const val WOOD_CALORIFIC_VALUE = 16.8
    }
}
