package dev.shtanko.core.network.responses

import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Test

class BaseResponseTest {

    @Test
    fun `create base response should add correct attributes`() {
        val code = 200
        val status = "Ok"
        val message = "Ok"
        val data: DataResponse<String> = mock()

        val baseResponse = BaseResponse(
            code = code,
            status = status,
            message = message,
            data = data
        )

        assertEquals(code, baseResponse.code)
        assertEquals(status, baseResponse.status)
        assertEquals(message, baseResponse.message)
        assertEquals(data, baseResponse.data)
    }
}
