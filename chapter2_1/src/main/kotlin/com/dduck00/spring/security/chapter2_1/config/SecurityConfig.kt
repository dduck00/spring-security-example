package com.dduck00.spring.security.chapter2_1.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun userDetailsService(): UserDetailsService {
        val userDetailsManager = InMemoryUserDetailsManager()

        val user = User.withUsername("Duck")
            .password("1234")
            .authorities("read")
            .build()

        userDetailsManager.createUser(user)

        return userDetailsManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    @Bean
    fun filterChainBasic(http: HttpSecurity): SecurityFilterChain {
        http.httpBasic()
        http.authorizeHttpRequests().anyRequest().permitAll()

        return http.build()
    }
}
