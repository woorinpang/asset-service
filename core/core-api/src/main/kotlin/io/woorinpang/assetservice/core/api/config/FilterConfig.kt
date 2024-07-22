package io.woorinpang.assetservice.core.api.config

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig {
    @Bean
    fun loggingFilter(): FilterRegistrationBean<AuthenticatedUserFilter> {
        val registrationBean = FilterRegistrationBean(AuthenticatedUserFilter())
        registrationBean.addUrlPatterns("/assets/*")
        return registrationBean
    }
}