package io.woorinpang.assetservice.core.api.support.error

import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus

enum class ApiErrorType(val status: HttpStatus, val code: ApiErrorCode, val message: String, val logLevel: LogLevel) {
    DEFAULT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, ApiErrorCode.E500, "An unexpected error has occurred.", LogLevel.ERROR),
}
