package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.storage.db.core.asset.AssetEntity
import io.woorinpang.assetservice.storage.db.core.asset.AssetJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetAppender(
    val assetRepository: AssetJpaRepository,
) {
    @Transactional
    fun append(assetType: AssetType): Long {
        return assetRepository.save(AssetEntity.of(userId = 1L, type = assetType,)).id!!
    }
}
