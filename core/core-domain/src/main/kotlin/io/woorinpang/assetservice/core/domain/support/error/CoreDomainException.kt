package io.woorinpang.assetservice.core.domain.support.error

class CoreDomainException(
    val errorType: DomainErrorType,
    val data: Any?
) {
}