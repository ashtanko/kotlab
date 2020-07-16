package dev.shtanko.server.config

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncoderBeanWrapper {
    private val encoderOauth: PasswordEncoder by lazy {
        BCryptPasswordEncoder(4)
    }
    private val encoder: PasswordEncoder by lazy {
        BCryptPasswordEncoder(8)
    }

    @Bean
    fun oauthClientPasswordEncoder(): PasswordEncoder = encoderOauth

    @Bean
    fun userPasswordEncoder(): PasswordEncoder = encoder
}
