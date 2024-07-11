package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.Asset
import io.woorinpang.assetservice.storage.db.core.asset.AssetRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetAppender(
    val assetRepository: AssetRepository,
) {
    @Transactional
    fun append(assetType: AssetType): Long {
        return assetRepository.save(Asset.of(userId = 1L, type = assetType,)).id!!
    }
}
