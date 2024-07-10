package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.Asset
import io.woorinpang.assetservice.storage.db.core.asset.AssetRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetFinder(
    val assetRepository: AssetRepository
) {
    @Transactional(readOnly = true)
    fun find(assetId: Long): Asset {
        return assetRepository.findById(assetId).orElseThrow { IllegalArgumentException("Invalid asset id: $assetId") }
    }
}
