package io.woorinpang.assetservice.core.api.controller

import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class HealthController(
    val env: Environment,
) {
    @GetMapping("/health")
    fun health(): ResponseEntity<String> {
        return ResponseEntity.ok().body("asset-service")
    }

    @GetMapping("/actuator/info")
    fun status(): String {
        val property = env.getProperty("local.server.port")
        return """
            GET User Service on
            local.server.port : {0}
            """.trimIndent().replace("{0}", Objects.requireNonNull(property)!!)
    }
}
