/*
 * Copyright 2024 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.annotations

/**
 * This annotation is used to mark classes, functions, or properties that implement or are related to the
 * Union-Find data structure.
 *
 * Union-Find is a data structure that tracks a partition of a set into disjoint subsets. It provides near
 * constant-time operations for adding new sets, merging sets, and determining whether elements are in the same set.
 *
 * @property info An optional string that provides additional information about the Union-Find implementation
 * or usage.
 * @constructor Creates a new Union-Find annotation.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class UnionFind(val info: String = "")
