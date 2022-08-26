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

package dev.shtanko.kotlinlang.generics

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CovarianceTest {

    @Test
    internal fun `covariance test`() {
        val s = EmptySource()
        assertThat(demo(s)).isExactlyInstanceOf(EmptySource::class.java)

        val bank1: Bank<Account> // = AccountBank() TODO
        val bank2: Bank<Deposit> = DepositBank()

        // val dep: Deposit = bank2.produce(200) // TODO
        // val acc: Account = bank1.produce(100) // TODO

        bank1 = bank2
        assertThat(bank1).isExactlyInstanceOf(DepositBank::class.java)

        val ints: Array<Int> = arrayOf(1, 2, 3)
        val any = Array<Any>(3) {}
        copy(ints, any)

        // val doubleList: List<Double> = listOf(1.0, 2.0) // TODO
        // val numberList: List<Number> = doubleList // TODO
    }
}
