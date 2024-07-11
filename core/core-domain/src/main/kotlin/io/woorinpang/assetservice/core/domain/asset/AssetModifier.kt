package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.AssetRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetModifier(
    val assetRepository: AssetRepository,
) {
    @Transactional
    fun modify(assetId: Long, assetType: String) {
        assetRepository
            .findById(assetId).orElseThrow { IllegalArgumentException("Invalid asset id: $assetId") }
            .modify(AssetType.valueOf(assetType))
    }
}
