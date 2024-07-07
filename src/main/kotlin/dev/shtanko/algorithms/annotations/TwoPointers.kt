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
 * # How Two Pointers Work
 * * Initialization: Typically, you initialize two pointers at different positions.
 * For example, one pointer might start at the beginning of an array, and the other might start at the end.
 * * Movement: The pointers are then moved towards each other or in a way that helps in achieving the desired condition.
 * This movement is usually based on some condition or criteria defined by the problem.
 * * Comparison or Calculation: At each step, you perform some comparison or calculation involving the elements at the
 * pointers’ positions.
 * * Termination: The process continues until the pointers meet or cross each other, or until a certain condition is met
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class TwoPointers(val info: String = "")
