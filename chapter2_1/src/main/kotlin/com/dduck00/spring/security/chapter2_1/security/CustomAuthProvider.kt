package com.dduck00.spring.security.chapter2_1.security

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class CustomAuthProvider : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        val userName = authentication.name
        val password = authentication.credentials.toString()

        if (userName == "Duck" && "12344" == password) {
            return UsernamePasswordAuthenticationToken(
                userName, password, listOf()
            )
        } else {
            throw AuthenticationCredentialsNotFoundException("EE")
        }
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}
