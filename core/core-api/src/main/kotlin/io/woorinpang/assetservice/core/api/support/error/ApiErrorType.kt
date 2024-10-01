package io.woorinpang.assetservice.core.api.support.error

import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus

enum class ApiErrorType(val status: HttpStatus, val code: ApiErrorCode, val message: String, val logLevel: LogLevel) {
    INVALID_ASSET_TYPE(HttpStatus.BAD_REQUEST, ApiErrorCode.E400, "Invalid asset type.", LogLevel.ERROR),

    INVALID_REQUEST_VALUE(HttpStatus.BAD_REQUEST, ApiErrorCode.E400, "Invalid request value.", LogLevel.ERROR),
    DEFAULT_ERROR(
        HttpStatus.INTERNAL_SERVER_ERROR,
        ApiErrorCode.E500,
        "An unexpected error has occurred.",
        LogLevel.ERROR,
    ),
}
