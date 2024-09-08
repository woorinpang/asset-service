package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.AssetEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetFinder(
    val assetEntityJpaRepository: AssetEntityJpaRepository,
) {
    @Transactional(readOnly = true)
    fun find(target: AssetTarget): Asset {
        return Asset.of(AssetHelper.findAssetById(assetEntityJpaRepository, target.id))
    }
}
