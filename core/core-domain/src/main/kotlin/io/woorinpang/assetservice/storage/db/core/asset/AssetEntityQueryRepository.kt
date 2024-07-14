package io.woorinpang.assetservice.storage.db.core.asset

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class AssetEntityQueryRepository(
    val queryFactory: JPAQueryFactory
) {
    fun findAssets(): List<AssetEntity> {
//        return queryFactory
//            .select(QAsset.asset)
//            .from(QAsset.asset)
//            .fetch()
        return emptyList()
    }
}