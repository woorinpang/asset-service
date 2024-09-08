package io.woorinpang.assetservice.storage.db.core.asset

import com.querydsl.jpa.impl.JPAQueryFactory
import io.woorinpang.assetservice.storage.db.core.asset.QAdminAssetEntity.adminAssetEntity
import org.springframework.stereotype.Repository

@Repository
class AdminAssetEntityQueryRepository(
    val queryFactory: JPAQueryFactory,
) {
    fun findAssets(): List<AdminAssetEntity> {
        return queryFactory
            .select(adminAssetEntity)
            .from(adminAssetEntity)
            .fetch()
    }
}
