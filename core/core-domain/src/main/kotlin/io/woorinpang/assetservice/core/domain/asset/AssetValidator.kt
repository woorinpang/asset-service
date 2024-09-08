package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType
import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.asset.AssetEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AssetValidator(
    val assetEntityJpaRepository: AssetEntityJpaRepository,
) {
    @Transactional(readOnly = true)
    fun validCreatedBy(
        target: AssetTarget,
        user: User,
    ) {
        AssetHelper
            .findAssetById(assetEntityJpaRepository, target.id)
            .equalCreatedBy(user.email)
            .takeIf { it }
            ?: throw CoreDomainException(DomainErrorType.ASSET_CREATED_BY_NOT_EQUAL)
    }

    fun validExistsUserIdAndType(
        user: User,
        type: AssetType,
    ) {
        assetEntityJpaRepository.existsByUserIdAndType(user.id, type.name)
            .takeIf { it }
            ?.let { throw CoreDomainException(DomainErrorType.ASSET_USER_ID_AND_TYPE_ALREADY_EXISTS) }
    }

    @Transactional(readOnly = true)
    fun validUserAsset(
        target: AssetTarget,
        user: User,
        type: AssetType,
    ) {
        val findAsset = AssetHelper.findAssetById(assetEntityJpaRepository, target.id)

        findAsset.equalAssetType(type.name)
            .takeIf { it }
            ?: throw CoreDomainException(DomainErrorType.ASSET_TYPE_NOT_EQUAL)

        findAsset.equalUserId(user.id)
            .takeIf { it }
            ?: throw CoreDomainException(DomainErrorType.ASSET_USER_ID_NOT_EQUAL)

        findAsset.isDeleted()
            .takeIf { it }
            ?.let { throw CoreDomainException(DomainErrorType.ASSET_DELETED) }
    }
}
