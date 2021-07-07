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

package dev.shtanko.di.multibindings

import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.math.BigDecimal
import kotlin.reflect.KClass

private const val ABC_VALUE = "value for ABC"
private const val DEF_VALUE = "value for DEF"
private const val BD_VALUE = "value for BigDecimal"

enum class MapKeyEnum {
    ABC, DEF
}

@MapKey
internal annotation class MyEnumKey(val value: MapKeyEnum)

@MapKey
internal annotation class MyNumberClassKey(val value: KClass<out Number>)

@Component(modules = [MapKeyModuleA::class])
interface MapKeyMultibindingsComponent {
    fun myEnumStringMap(): Map<MapKeyEnum, String>
    fun stringsByNumberClass(): Map<Class<out Number>, String>
}

@Module
class MapKeyModuleA {

    @Provides
    @IntoMap
    @MyEnumKey(MapKeyEnum.ABC)
    fun provideABCValue(): String = ABC_VALUE

    @Provides
    @IntoMap
    @MyEnumKey(MapKeyEnum.DEF)
    fun provideDEFValue(): String = DEF_VALUE

    @Provides
    @IntoMap
    @MyNumberClassKey(BigDecimal::class)
    fun provideBigDecimalValue() = BD_VALUE
}
