package dev.shtanko.server

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/dummy/open"])
class DummyOpenResource {

    @RequestMapping(method = [RequestMethod.GET])
    fun get(): String {
        return "Open"
    }
}
