package io.woorinpang.assetservice.admin.support.page

import com.mysema.commons.lang.Assert

data class AdminPage<T> private constructor(
    val content: List<T>,
    val page: AdminPageInfo
) {
    companion object {
        fun <S> of(content: List<S>, page: AdminPageInfo): AdminPage<S> {
            return AdminPage(content, page)
        }
    }

    fun <S> map(converter: (T) -> S): AdminPage<S> {
        Assert.notNull(converter, "Function must not be null")
        return AdminPage(content.map(converter), page)
    }
}
