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

package dev.shtanko.concurrency.rx

import dev.shtanko.concurrency.core.RxJavaTest
import dev.shtanko.concurrency.core.TestObserverEx
import io.reactivex.rxjava3.core.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.ArrayList
import java.util.Comparator

class ObservableCovarianceTest : RxJavaTest() {

    @Test
    fun `Covariance Of From`() {
        Observable.just<Movie>(HorrorMovie())
        Observable.fromIterable<Movie>(ArrayList<HorrorMovie>())
    }

    @Test
    fun `Sorted List`() {
        val sortFunction: Comparator<Media> = Comparator { _, _ -> 1 }

        // this one would work without the covariance generics

        // this one would work without the covariance generics
        val o: Observable<Media> = Observable.just(
            Movie(),
            TVSeason(),
            Album()
        )
        o.toSortedList(sortFunction)

        // this one would NOT work without the covariance generics

        // this one would NOT work without the covariance generics
        val o2 = Observable.just(Movie(), ActionMovie(), HorrorMovie())
        o2.toSortedList(sortFunction)
    }

    @Test
    fun `Group By Compose`() {
        val movies = Observable.just(HorrorMovie(), ActionMovie(), Movie())
        val to: TestObserverEx<String> = TestObserverEx()
        movies
            .groupBy<Any> { v -> v.javaClass }
            .doOnNext { g -> println(g.key) }
            .flatMap { g ->
                g.doOnNext { pv -> println(pv) }
                    .compose { m -> m.concatWith(Observable.just(ActionMovie())) }
                    .map { v -> v.toString() }
            }
            .subscribe(to)
        to.assertTerminated()
        to.assertNoErrors()
        assertThat(to.values().size).isEqualTo(6)
        //        System.out.println(ts.getOnNextEvents());
        //        System.out.println(ts.getOnNextEvents());
        // assertEquals(6, to.values().size())
    }

    internal open class Media

    internal open class Movie : Media()

    internal class HorrorMovie : Movie()

    internal class ActionMovie : Movie()

    internal class Album : Media()

    internal class TVSeason : Media()

    internal open class Rating

    internal class CoolRating : Rating()

    internal open class Result

    internal class ExtendedResult : Result()
}
