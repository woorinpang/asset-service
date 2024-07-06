package io.woorinpang.assetservice.admin.support.error

import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus

enum class AdminApiErrorType(val status: HttpStatus, val code: AdminApiErrorCode, val message: String, val level: LogLevel) {
    DEFAULT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, AdminApiErrorCode.E500, "An unexpected error has occurred.", LogLevel.ERROR),
}
