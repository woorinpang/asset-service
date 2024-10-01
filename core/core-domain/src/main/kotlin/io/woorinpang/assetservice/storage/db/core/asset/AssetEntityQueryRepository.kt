package io.woorinpang.assetservice.storage.db.core.asset

import com.querydsl.jpa.impl.JPAQueryFactory
import io.woorinpang.assetservice.storage.db.core.asset.QAssetEntity.assetEntity
import org.springframework.stereotype.Repository

@Repository
class AssetEntityQueryRepository(
    val queryFactory: JPAQueryFactory,
) {
    fun findAssets(): List<AssetEntity> {
        return queryFactory
            .select(assetEntity)
            .from(assetEntity)
            .fetch()
    }
}
