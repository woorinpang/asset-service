package io.woorinpang.assetservice.core.api.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class AuthenticatedUserFilter : OncePerRequestFilter() {
    private val objectMapper = ObjectMapper().registerKotlinModule()

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val encodedUserJson = request.getHeader("Authenticated-User")

        if (!encodedUserJson.isNullOrEmpty()) {
            try {
                val decodedUser = URLDecoder.decode(encodedUserJson, StandardCharsets.UTF_8)
                val authenticatedUser: AuthenticatedUser = objectMapper.readValue(decodedUser, AuthenticatedUser::class.java)
                request.setAttribute("authenticatedUser", authenticatedUser)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        filterChain.doFilter(request, response)
    }
}