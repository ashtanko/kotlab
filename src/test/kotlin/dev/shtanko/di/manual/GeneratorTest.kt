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

import java.util.stream.Stream
import kotlin.time.Duration.Companion.hours
import kotlin.time.ExperimentalTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

@OptIn(ExperimentalTime::class)
class GeneratorTest {

    internal class InputHoursArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                false,
            ),
            Arguments.of(
                9,
                false,
            ),
            Arguments.of(
                10,
                false,
            ),
            Arguments.of(
                11,
                true,
            ),
            Arguments.of(
                15,
                true,
            ),
            Arguments.of(
                100,
                true,
            ),
        )
    }

    internal class InputDurationArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                100.0,
            ),
            Arguments.of(
                9,
                100.0,
            ),
            Arguments.of(
                10,
                100.0,
            ),
            Arguments.of(
                11,
                150.0,
            ),
            Arguments.of(
                15,
                150.0,
            ),
            Arguments.of(
                100,
                150.0,
            ),
        )
    }

    @Test
    fun `petrol generator v1 consumption millis test`() {
        val actual = PetrolGenerator1.consumptionMillis()
        assertThat(actual).isEqualTo(36_000_000)
    }

    @ParameterizedTest
    @ArgumentsSource(InputDurationArgumentsProvider::class)
    fun `petrol ensure capacity test`(hours: Int, expected: Double) {
        val petrol = PremiumUnleadedPetrol()
        val generator = PetrolGenerator1(petrol)
        generator.ensureCapacity(hours.hours)
        val actual = generator.tankCapacity()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `petrol tank capacity test`() {
        val petrol = PremiumUnleadedPetrol()
        val generator: PetrolGenerator = PetrolGenerator1(petrol)
        val actual = generator.tankCapacity()
        assertThat(actual).isEqualTo(100.0)
    }

    @Test
    fun `petrol generator v1 grow test`() {
        val petrol = PremiumUnleadedPetrol()
        val generator = PetrolGenerator1(petrol)
        generator.grow()
        assertThat(generator.tankCapacity()).isEqualTo(150.0)
        generator.grow()
        assertThat(generator.tankCapacity()).isEqualTo(225.0)
        generator.grow()
        assertThat(generator.tankCapacity()).isEqualTo(337.5)
    }

    @ParameterizedTest
    @ArgumentsSource(InputHoursArgumentsProvider::class)
    fun `petrol generator v1 9 hours test`(hours: Int, expected: Boolean) {
        val actual = PetrolGenerator1.isNeedMoreFuel(hours.hours)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `petrol generator v1 11 hours test`() {
        val h = 11
        val actual = PetrolGenerator1.isNeedMoreFuel(h.hours)
        assertThat(actual).isEqualTo(true)
    }

    @Test
    fun `petrol generator v1 premium petrol for 2 hours`() {
        val h = 2
        val petrol = PremiumUnleadedPetrol()
        val generator: PetrolGenerator = PetrolGenerator1(petrol)
        val actual = generator.generate(h.hours).power
        assertThat(actual).isEqualTo(1277.7777777777778)
    }
}
