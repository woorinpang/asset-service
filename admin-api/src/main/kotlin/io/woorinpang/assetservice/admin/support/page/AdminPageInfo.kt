package io.woorinpang.assetservice.admin.support.page

data class AdminPageInfo(
    val number: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int,
    val isFirst: Boolean,
    val isLast: Boolean
)
