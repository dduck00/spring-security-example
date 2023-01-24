package com.dduck00.spring.security.chapter2_1.config

import javax.sql.DataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun userDetailsService(dataSource: DataSource): UserDetailsService {
        val getUserByUserNameQuery = """
            select username, password, enabled from users where username = ?
        """.trimIndent()

        val getAuthsByUsernameQuery = """
            select username, authority from authorities where username = ?
        """.trimIndent()

        val userDetailsManager =JdbcUserDetailsManager(dataSource)
        userDetailsManager.setUsersByUsernameQuery(getUserByUserNameQuery)
        userDetailsManager.setAuthoritiesByUsernameQuery(getAuthsByUsernameQuery)
        return userDetailsManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    @Bean
    fun filterChainBasic(http: HttpSecurity): SecurityFilterChain {
        http.httpBasic()
        http.authorizeHttpRequests().anyRequest().authenticated()

        return http.build()
    }
}
