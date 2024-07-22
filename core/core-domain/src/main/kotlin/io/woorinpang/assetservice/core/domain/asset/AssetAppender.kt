package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntity
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetAppender(
    val assetRepository: AssetEntityJpaRepository,
) {
    @Transactional
    fun append(user: User, type: AssetType): Long {
        return assetRepository.save(AssetEntity.of(userId = user.id, type = type.name, user.email)).id!!
    }
}
