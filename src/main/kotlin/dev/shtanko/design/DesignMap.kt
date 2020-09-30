package dev.shtanko.design

interface DesignMap<K, V> {

    fun isEmpty(): Boolean

    fun containsKey(key: K): Boolean

    fun containsValue(value: @UnsafeVariance V): Boolean

    operator fun get(key: K): V?

    fun put(key: K, value: V): V?

    fun remove(key: K): V?

    fun clear(): Unit
}
