package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Service

@Service
class AssetService(
    val assetAppender: AssetAppender,
    val assetFinder: AssetFinder,
    val assetRemover: AssetRemover,
    val assetValidator: AssetValidator,
) {
    fun appendAsset(type: AssetType, user: User): Long {
        return assetAppender.append(type, user)
    }

    fun findAsset(target: AssetTarget): Asset {
        return assetFinder.find(target)
    }

    fun deleteAsset(target: AssetTarget, user: User): Any {
        assetValidator.validCreatedBy(target, user)
        return assetRemover.remove(target, user)
    }
}
