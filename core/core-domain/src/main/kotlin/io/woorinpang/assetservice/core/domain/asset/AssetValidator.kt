package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.support.error.CoreDomainException
import io.woorinpang.assetservice.core.domain.support.error.DomainErrorType
import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.core.enums.AssetType
import org.springframework.stereotype.Component

@Component
class AssetValidator(
    val assetRepository: AssetRepository,
) {
    fun validCreatedBy(target: AssetTarget) {
        val findAsset = AssetHelper.findAssetById(assetRepository, target.id)
    }

    fun existsUserIdAndType(
        userId: Long,
        type: AssetType,
    ) {
        val existsByUserIdAndType = assetRepository.existsByUserIdAndType(userId, type)
        if (existsByUserIdAndType) {
            throw CoreDomainException(DomainErrorType.ASSET_USER_ID_AND_TYPE_ALREADY_EXISTS)
        }
    }

    fun validUserAsset(
        target: AssetTarget,
        user: User,
        type: AssetType,
    ) {
        val findAsset = AssetHelper.findAssetById(assetRepository, target.id)
        if (findAsset.type != type) {
            throw CoreDomainException(DomainErrorType.ASSET_TYPE_NOT_EQUAL)
        }

        if (findAsset.userId != user.id) {
            throw CoreDomainException(DomainErrorType.ASSET_USER_ID_NOT_EQUAL)
        }

        if (findAsset.deleted) {
            throw CoreDomainException(DomainErrorType.ASSET_DELETED)
        }
    }
}
