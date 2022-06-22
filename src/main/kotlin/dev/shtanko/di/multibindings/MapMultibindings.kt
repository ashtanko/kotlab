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

package dev.shtanko.di.multibindings

/*
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

private const val FOO_VALUE = 100L
private const val THING_VALUE = "value for Thing"

@Component(modules = [MapMModuleA::class])
interface MapMultibindingsComponent {
    fun longsByString(): Map<String, Long>
    fun stringsByClass(): Map<Class<*>, String>
}

class Thing

@Module
class MapMModuleA {
    @Provides
    @IntoMap
    @StringKey("foo")
    fun provideFooValue(): Long = FOO_VALUE

    @Provides
    @IntoMap
    @ClassKey(Thing::class)
    fun provideThingValue(): String = THING_VALUE
}
*/
