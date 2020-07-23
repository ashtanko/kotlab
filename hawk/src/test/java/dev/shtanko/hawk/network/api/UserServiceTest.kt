package dev.shtanko.hawk.network.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MockResponses {
    object GetCurrentUser {
        const val STATUS_200 = "mock-responses/get-current-user-status200.json"
        const val STATUS_401 = "mock-responses/get-current-user-status401.json"
    }
}

class UserServiceTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var service: UserService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `request get current user`() = runBlocking {
        enqueueResponse(MockResponses.GetCurrentUser.STATUS_200)
        service.getCurrentUser()

        val request = mockWebServer.takeRequest()
        Assert.assertEquals("GET", request.method)
        Assert.assertEquals(
            "/v1/me",
            request.path
        )
    }

    @Test
    fun `response get current user status code 401`() = runBlocking {
        enqueueResponse(MockResponses.GetCurrentUser.STATUS_401)
        val response = service.getCurrentUser()

        Assert.assertEquals("InvalidCredentials", response.code)
        Assert.assertEquals(
            "That hash, timestamp and key combination is invalid.",
            response.message
        )
        Assert.assertNull(response.status)
        Assert.assertNull(response.data)
    }

    private fun enqueueResponse(filePath: String) {
        val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
        val bufferSource = inputStream?.source()?.buffer()
        val mockResponse = MockResponse()

        mockWebServer.enqueue(
            mockResponse.setBody(
                bufferSource!!.readString(Charsets.UTF_8)
            )
        )
    }
}
