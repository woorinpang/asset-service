package io.woorinpang.assetservice.core.domain.support.error

data class DomainErrorMessage private constructor(
    val code: String,
    val message: String
){
    constructor(errorType: DomainErrorType) : this(
        code = errorType.code.name,
        message = errorType.message
    )
}