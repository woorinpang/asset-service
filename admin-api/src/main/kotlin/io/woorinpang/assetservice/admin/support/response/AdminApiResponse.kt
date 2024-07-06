package io.woorinpang.assetservice.admin.support.response

import io.woorinpang.assetservice.admin.support.error.AdminApiErrorMessage
import io.woorinpang.assetservice.admin.support.error.AdminApiErrorType

data class AdminApiResponse<T> private constructor(
    val result : AdminResultType,
    val data : T? = null,
    val error : AdminApiErrorMessage? = null
){
    companion object {
        fun success(): AdminApiResponse<Any> {
            return AdminApiResponse(AdminResultType.SUCCESS, null, null)
        }

        fun <S> success(data: S): AdminApiResponse<S> {
            return AdminApiResponse(AdminResultType.SUCCESS, data, null)
        }

        fun <S> error(error: AdminApiErrorType, errorData: Any? = null): AdminApiResponse<S> {
            return AdminApiResponse(AdminResultType.ERROR, null, AdminApiErrorMessage(error, errorData))
        }
    }
}