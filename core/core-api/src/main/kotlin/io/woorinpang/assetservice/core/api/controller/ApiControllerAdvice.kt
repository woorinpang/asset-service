package io.woorinpang.assetservice.core.api.controller

import io.woorinpang.assetservice.core.api.support.error.ApiErrorType
import io.woorinpang.assetservice.core.api.support.error.CoreApiException
import io.woorinpang.assetservice.core.api.support.error.CustomMethodArgumentNotValidException
import io.woorinpang.assetservice.core.api.support.error.FieldError
import io.woorinpang.assetservice.core.api.support.response.ApiResponse
import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ApiResponse<Any>> {
        log.info("handleMethodArgumentNotValidException = {}", e.message, e)
        val fieldErrors = e.fieldErrors.map { FieldError.of(it) }
        return ResponseEntity(
            ApiResponse.error(ApiErrorType.INVALID_REQUEST_VALUE, fieldErrors),
            HttpStatus.BAD_REQUEST,
        )
    }

    @ExceptionHandler(CustomMethodArgumentNotValidException::class)
    fun handleCustomMethodArgumentNotValidException(
        e: CustomMethodArgumentNotValidException,
    ): ResponseEntity<ApiResponse<Any>> {
        log.info("handleCustomMethodArgumentNotValidException = {}", e.message, e)
        return ResponseEntity(ApiResponse.error(ApiErrorType.INVALID_REQUEST_VALUE, e.errors), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(CoreApiException::class)
    fun handleCoreApiException(e: CoreApiException): ResponseEntity<ApiResponse<Any>> {
        when (e.errorType.logLevel) {
            LogLevel.ERROR -> log.error("handleCoreApiException : {}", e.message, e)
            LogLevel.WARN -> log.warn("handleCoreApiException : {}", e.message, e)
            else -> log.info("handleCoreApiException : {}", e.message, e)
        }
        return ResponseEntity(ApiResponse.error(e.errorType, e.data), e.errorType.status)
    }

    @ExceptionHandler(CoreDomainException::class)
    fun handleCoreDomainException(e: CoreDomainException): ResponseEntity<ApiResponse<Any>> {
        log.info("handleCoreDomainException = {}", e.message, e)
        return ResponseEntity(ApiResponse.error(e.errorType), HttpStatus.OK)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Any>> {
        log.error("handleException : {}", e.message, e)
        return ResponseEntity(ApiResponse.error(ApiErrorType.DEFAULT_ERROR), ApiErrorType.DEFAULT_ERROR.status)
    }
}
