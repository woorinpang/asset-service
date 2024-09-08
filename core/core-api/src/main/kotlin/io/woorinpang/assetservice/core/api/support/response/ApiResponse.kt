package io.woorinpang.assetservice.core.api.support.response

import io.woorinpang.assetservice.core.api.support.error.ApiErrorMessage
import io.woorinpang.assetservice.core.api.support.error.ApiErrorType
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorMessage
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType

data class ApiResponse<T> private constructor(
    val result: ResultType,
    val data: T? = null,
    val error: Any? = null,
) {
    companion object {
        fun success(): ApiResponse<Any> {
            return ApiResponse(ResultType.SUCCESS, null, null)
        }

        fun <S> success(data: S): ApiResponse<S> {
            return ApiResponse(ResultType.SUCCESS, data, null)
        }

        fun <S> error(
            error: ApiErrorType,
            errorData: Any? = null,
        ): ApiResponse<S> {
            return ApiResponse(ResultType.ERROR, null, ApiErrorMessage(error, errorData))
        }

        fun error(error: DomainErrorType): ApiResponse<Any> {
            return ApiResponse(ResultType.ERROR, null, DomainErrorMessage(error))
        }
    }
}
