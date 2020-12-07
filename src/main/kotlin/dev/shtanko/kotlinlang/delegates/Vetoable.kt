package dev.shtanko.kotlinlang.delegates

import kotlin.properties.Delegates.vetoable
import kotlin.reflect.KProperty

val name by vetoable("Jack") { _: KProperty<*>, _, newValue ->
    newValue.startsWith("J")
}
