package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.AssetJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetFinder(
    val assetJpaRepository: AssetJpaRepository
) {
    @Transactional(readOnly = true)
    fun find(assetId: Long): Asset {
        return Asset.of(AssetRepositoryHelper.findAssetById(assetJpaRepository, assetId))
    }
}
