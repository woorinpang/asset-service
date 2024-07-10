package io.woorinpang.assetservice.storage.db.core.asset

import com.querydsl.jpa.impl.JPAQueryFactory

class AssetQueryRepository(
    val queryFactory: JPAQueryFactory
) {
    fun findAssets(): List<Asset> {
        return queryFactory
            .select(QAsset.asset)
            .from(QAsset.asset)
            .fetch()
    }
}