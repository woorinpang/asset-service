package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType
import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntityJpaRepository
import org.springframework.stereotype.Component

@Component
class AssetValidator(
    val assetEntityJpaRepository: AssetEntityJpaRepository
) {
    fun validCreatedBy(target: AssetTarget, user: User) {
        AssetHelper
            .findAssetById(assetEntityJpaRepository, target.id)
            .equalCreatedBy(user.email)
            .takeIf { it }
            ?: throw CoreDomainException(DomainErrorType.ASSET_NOT_FOUND)
    }
}