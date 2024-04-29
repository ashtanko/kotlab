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

package dev.shtanko.patterns.structural.flyweight.example1

import dev.shtanko.patterns.structural.flyweight.example1.forest.Forest
import java.awt.Color
import java.awt.Graphics
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class ForestTest {

    @Test
    fun `plantTree adds tree to forest`() {
        val forest = Forest()
        forest.plantTree(1, 2, "Oak", Color.GREEN, "Oak data")

        assertEquals(1, forest.treeList.size)
    }

    @Test
    fun `plantTree creates tree with correct attributes`() {
        val forest = Forest()
        forest.plantTree(1, 2, "Oak", Color.GREEN, "Oak data")

        val tree = forest.treeList[0]
        assertEquals(1, tree.x)
        assertEquals(2, tree.y)
        assertEquals("Oak", tree.type.name)
        assertEquals(Color.GREEN, tree.type.color)
        assertEquals("Oak data", tree.type.otherTreeData)
    }

    @Test
    fun `paint draws all trees in forest`() {
        val forest = Forest()
        forest.plantTree(1, 2, "Oak", Color.GREEN, "Oak data")
        forest.plantTree(3, 4, "Pine", Color.GREEN, "Pine data")

        val graphics = Mockito.mock(Graphics::class.java)
        forest.paint(graphics)

        Mockito.verify(graphics, Mockito.times(2))
            .fillRect(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())
        Mockito.verify(graphics, Mockito.times(2))
            .fillOval(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())
    }
}
