package io.woorinpang.assetservice.core.domain.support.error

enum class DomainErrorType(val code: DomainErrorCode, val message: String) {
    ASSET_NOT_FOUND(DomainErrorCode.E1000, "Asset not found."),
    ASSET_CREATED_BY_NOT_EQUAL(DomainErrorCode.E1000, "Asset created by not equal."),

    ELECTRONIC_DEVICE_NOT_FOUND(DomainErrorCode.E1000, "Electronic device not found."),
    ELECTRONIC_DEVICE_CREATED_BY_NOT_EQUAL(DomainErrorCode.E1000, "Electronic device created by not equal."),

    DEFAULT_ERROR(DomainErrorCode.E9999, "An unexpected error has occurred."),
}
