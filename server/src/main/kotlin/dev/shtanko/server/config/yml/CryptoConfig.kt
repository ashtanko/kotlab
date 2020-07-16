package dev.shtanko.server.config.yml

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("crypto")
class CryptoConfig {
    /**
     * The key to use for encryption.
     */
    lateinit var key: String

    /**
     * The algorithm to use for encryption.
     */
    lateinit var algorithm: String
}
