/*
 * Copyright 2023 Oleksii Shtanko
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

package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.annotations.Iterative
import java.util.Stack
import kotlin.math.abs

/**
 * 735. Asteroid Collision
 * @see <a href="https://leetcode.com/problems/asteroid-collision/">Source</a>
 */
fun interface AsteroidCollision {
    operator fun invoke(asteroids: IntArray): IntArray
}

/**
 * Approach: Stack
 */
@Iterative
class AsteroidCollisionStack : AsteroidCollision {

    override operator fun invoke(asteroids: IntArray): IntArray {
        val st: Stack<Int> = Stack<Int>()

        for (asteroid in asteroids) {
            var flag = true
            while (st.isNotEmpty() && st.peek() > 0 && asteroid < 0) {
                // If the top asteroid in the stack is smaller, then it will explode.
                // Hence, pop it from the stack, also continue with the next asteroid in the stack.
                if (abs(st.peek()) < abs(asteroid)) {
                    st.pop()
                    continue
                } else if (abs(st.peek()) == abs(asteroid)) {
                    st.pop()
                }

                // If we reach here, the current asteroid will be destroyed
                // Hence, we should not add it to the stack
                flag = false
                break
            }
            if (flag) {
                st.push(asteroid)
            }
        }

        // Add the asteroids from the stack to the vector in the reverse order.
        val remainingAsteroids = IntArray(st.size)
        for (i in remainingAsteroids.indices.reversed()) {
            remainingAsteroids[i] = st.peek()
            st.pop()
        }

        return remainingAsteroids
    }
}
