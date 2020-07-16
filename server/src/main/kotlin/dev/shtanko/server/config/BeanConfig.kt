package dev.shtanko.server.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dev.shtanko.server.config.yml.CryptoConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class BeanConfig {

    @Autowired
    private lateinit var cryptoConfig: CryptoConfig

    @Bean
    open fun objectMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        // KotlinModule is important for proper default constructor parameter use with Jackson and Kotlin classes
        mapper.registerModule(KotlinModule())
        return mapper
    }
}
