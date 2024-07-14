package io.woorinpang.assetservice.core.domain.support.error

enum class DomainErrorType(val code: DomainErrorCode, val message: String) {
    ASSET_NOT_FOUND(DomainErrorCode.E1000, "Asset not found."),

    DEFAULT_ERROR(DomainErrorCode.E9999, "An unexpected error has occurred."),
}
