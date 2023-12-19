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

package dev.shtanko.api

import dev.shtanko.utils.loadOrEmpty
import java.io.IOException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GitHubServiceTest {

    private val mockWebServer = MockWebServer()

    @BeforeEach
    @Throws(IOException::class)
    fun setUp() {
        mockWebServer.start()
    }

    @AfterEach
    @Throws(IOException::class)
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `create http client test`() {
        val httpClient = mockHttpClient
        assertThat(httpClient.interceptors).isNotEmpty
    }

    @Test
    fun `create retrofit default url test`() {
        val retrofit = createRetrofit(mockHttpClient)
        assertThat(retrofit.baseUrl().toString()).isEqualTo("https://api.github.com/")
    }

    @Test
    fun `create retrofit test`() {
        val retrofit = createRetrofit(mockHttpClient, "https://api.myservice.com/".toHttpUrl())
        assertThat(retrofit.baseUrl().toString()).isEqualTo("https://api.myservice.com/")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `fetch orgs test`() = runTest {
        val mockedResponse = createMockedResponse("orgs.json")
        mockWebServer.enqueue(mockedResponse)

        val response = getMockGitHubService().getOrgRepos("square")

        val body = response.body()
        assertThat(body).isNotNull
        body?.let {
            assertThat(it.size).isEqualTo(100)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get repo contributors test`() = runTest {
        val mockedResponse = createMockedResponse("contributors.json")
        mockWebServer.enqueue(mockedResponse)

        val response = getMockGitHubService().getRepoContributors(owner = "square", repo = "okhttp")

        val body = response.body()
        assertThat(body).isNotNull
        body?.let {
            assertThat(it.size).isEqualTo(100)
        }
    }

    private val mockHttpClient = createHttpClient("test")

    private fun getMockGitHubService(): GitHubService {
        return createGitHubService(
            "name",
            "pass",
            retrofit = createRetrofit(mockHttpClient, baseUrl = mockWebServer.url("/")),
        )
    }

    private fun createMockedResponse(jsonFileName: String): MockResponse {
        return MockResponse().setBody(jsonFileName.loadOrEmpty()).addHeader("Content-Type", "application/json")
    }
}
