/*
 * Copyright 2022 Oleksii Shtanko
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

package dev.shtanko.patterns.behavioral.strategy

import java.io.BufferedReader
import java.io.InputStreamReader

object EcommerceApp {

    private val priceOnProducts: Map<Int, Int> = HashMap<Int, Int>().apply {
        put(1, 2200)
        put(2, 1850)
        put(3, 1100)
        put(4, 890)
    }
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private val order = Order()
    private lateinit var strategy: PayStrategy

    @JvmStatic
    fun main(args: Array<String>) {
        while (!order.isClosed) {
            var cost: Int
            var continueChoice: String
            do {
                print(
                    "Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n",
                )
                val choice = reader.readLine().toInt()
                cost = priceOnProducts[choice] ?: 0
                print("Count: ")
                val count = reader.readLine().toInt()
                order.totalCost = cost * count
                print("Do you wish to continue selecting products? Y/N: ")
                continueChoice = reader.readLine()
            } while (continueChoice.equals("Y", ignoreCase = true))

            println(
                "Please, select a payment method:" + "\n" +
                    "1 - PalPay" + "\n" +
                    "2 - Credit Card",
            )
            val paymentMethod = reader.readLine()

            // Client creates different strategies based on input from user,
            // application configuration, etc.
            strategy = if (paymentMethod == "1") {
                PayByPayPal()
            } else {
                PayByCreditCard()
            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(strategy)
            print("Pay " + order.totalCost + " units or Continue shopping? P/C: ")
            val proceed = reader.readLine()
            if (proceed.equals("P", ignoreCase = true)) {
                // Finally, strategy handles the payment.
                if (strategy.pay(order.totalCost)) {
                    println("Payment has been successful.")
                } else {
                    println("FAIL! Please, check your data.")
                }
                order.setClosed()
            }
        }
    }
}
