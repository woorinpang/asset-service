package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType
import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntity
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetValidator(
    val assetEntityJpaRepository: AssetEntityJpaRepository
) {
    @Transactional(readOnly = true)
    fun validCreatedBy(target: AssetTarget, user: User) {
        AssetHelper
            .findAssetById(assetEntityJpaRepository, target.id)
            .equalCreatedBy(user.email)
            .takeIf { it }
            ?: throw CoreDomainException(DomainErrorType.ASSET_NOT_FOUND)
    }

    @Transactional(readOnly = true)
    fun validAssetIsElectronic(target: AssetTarget, type: AssetType) {
        AssetHelper.findAssetById(assetEntityJpaRepository, target.id)
            .equalAssetType(type.name)
            .takeIf { it}
            ?: throw CoreDomainException(DomainErrorType.ASSET_TYPE_NOT_EQUAL)
    }
}