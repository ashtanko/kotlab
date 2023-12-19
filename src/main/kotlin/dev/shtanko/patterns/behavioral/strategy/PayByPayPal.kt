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
import java.io.IOException
import java.io.InputStreamReader

/**
 * Concrete strategy. Implements PayPal payment method.
 */
class PayByPayPal : PayStrategy {
    private val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    private var email: String? = null
    private var password: String? = null
    private var signedIn = false

    /**
     * Collect customer's data.
     */
    override fun collectPaymentDetails() {
        try {
            while (!signedIn) {
                print("Enter the user's email: ")
                email = bufferedReader.readLine()
                print("Enter the password: ")
                password = bufferedReader.readLine()
                if (verify()) {
                    println("Data verification has been successful.")
                } else {
                    println("Wrong email or password!")
                }
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    private fun verify(): Boolean {
        setSignedIn(email == DATA_BASE[password])
        return signedIn
    }

    /**
     * Save customer data for future shopping attempts.
     */
    override fun pay(paymentAmount: Int): Boolean {
        return if (signedIn) {
            println("Paying $paymentAmount using PayPal.")
            true
        } else {
            false
        }
    }

    private fun setSignedIn(signedIn: Boolean) {
        this.signedIn = signedIn
    }

    companion object {
        private val DATA_BASE: MutableMap<String?, String> = HashMap()

        init {
            DATA_BASE["amanda1985"] = "amanda@ya.com"
            DATA_BASE["qwerty"] = "john@amazon.eu"
        }
    }
}
