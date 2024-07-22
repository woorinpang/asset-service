package io.woorinpang.assetservice.core.api.support.error

class CustomMethodArgumentNotValidException(
    val errors: List<FieldError>,
) : RuntimeException()