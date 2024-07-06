package io.woorinpang.assetservice.core.domain.support.error

import org.springframework.boot.logging.LogLevel

enum class DomainErrorType(val code: DomainErrorCode, val message: String, val level: LogLevel) {
    DEFAULT_ERROR(DomainErrorCode.E9999, "An unexpected error has occurred.", LogLevel.ERROR),
}
