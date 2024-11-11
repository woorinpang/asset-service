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
    fun validCreatedBy(
        target: AssetTarget,
        user: User,
    ) {
        val findAsset = AssetHelper.findAssetById(assetRepository, target.id)
        if(findAsset.createdBy != user.email) {
            throw CoreDomainException(DomainErrorType.ASSET_CREATED_BY_NOT_EQUAL)
        }
    }

    fun existsUserIdAndType(
        user: User,
        type: AssetType,
    ) {
        val existsByUserIdAndType = assetRepository.existsByUserIdAndType(user.id, type)
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
