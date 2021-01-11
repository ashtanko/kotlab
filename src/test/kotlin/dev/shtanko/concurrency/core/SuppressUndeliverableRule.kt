/*
 * Copyright 2021 Alexey Shtanko
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

package dev.shtanko.concurrency.core

import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class SuppressUndeliverableRule : TestRule {

    override fun apply(base: Statement?, description: Description?): Statement {
        return if (description?.getAnnotation(SuppressUndeliverable::class.java) != null) {
            SuppressUndeliverableRuleStatement(base)
        } else {
            base ?: throw IllegalStateException("$base is null")
        }
    }

    internal class SuppressUndeliverableRuleStatement(private val base: Statement?) : Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            try {
                RxJavaPlugins.setErrorHandler { throwable: Throwable ->
                    if (throwable !is UndeliverableException) {
                        throwable.printStackTrace()
                        val currentThread = Thread.currentThread()
                        currentThread.uncaughtExceptionHandler.uncaughtException(currentThread, throwable)
                    }
                }
                base?.evaluate()
            } finally {
                RxJavaPlugins.setErrorHandler(null)
            }
        }
    }
}
