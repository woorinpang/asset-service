package io.woorinpang.assetservice.admin.support.error

data class AdminApiErrorMessage private constructor(
    val code: String,
    val message: String,
    val data: Any?

){
    constructor(errorType: AdminApiErrorType, data: Any? = null) : this(
        code = errorType.code.name,
        message = errorType.message,
        data = data
    )
}
