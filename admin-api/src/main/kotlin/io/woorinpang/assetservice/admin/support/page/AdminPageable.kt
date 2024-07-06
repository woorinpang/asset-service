package io.woorinpang.assetservice.admin.support.page

private const val DEFAULT_PAGE = 0
private const val DEFAULT_SIZE = 20

data class AdminPageable(
    val page: Int = DEFAULT_PAGE,
    val size: Int = DEFAULT_SIZE
) {
    fun toPageRequest(): AdminPageRequest {
        return AdminPageRequest(page, size)
    }
}