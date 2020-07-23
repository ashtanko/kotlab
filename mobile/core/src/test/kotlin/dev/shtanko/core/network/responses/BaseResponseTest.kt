package dev.shtanko.core.network.responses

import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
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

        Assert.assertEquals(code, baseResponse.code)
        Assert.assertEquals(status, baseResponse.status)
        Assert.assertEquals(message, baseResponse.message)
        Assert.assertEquals(data, baseResponse.data)
    }
}
