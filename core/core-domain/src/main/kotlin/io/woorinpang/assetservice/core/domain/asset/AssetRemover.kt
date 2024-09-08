package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetRemover(
    val assetEntityJpaRepository: AssetEntityJpaRepository,
) {
    @Transactional
    fun remove(
        target: AssetTarget,
        user: User,
    ) {
        AssetHelper
            .findAssetById(assetEntityJpaRepository, target.id)
            .delete(user.email)
    }
}
