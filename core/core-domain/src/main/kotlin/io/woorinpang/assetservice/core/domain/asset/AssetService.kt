package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.core.enums.AssetType
import org.springframework.stereotype.Service

@Service
class AssetService(
    val assetAppender: AssetAppender,
    val assetFinder: AssetFinder,
    val assetRemover: AssetRemover,
    val assetValidator: AssetValidator,
) {
    fun appendAsset(
        user: User,
        type: AssetType,
    ): Long {
        assetValidator.existsUserIdAndType(user, type)
        return assetAppender.append(user, type)
    }

    fun findAsset(target: AssetTarget): Asset = assetFinder.find(target)

    fun deleteAsset(
        target: AssetTarget,
        user: User,
    ): Any {
        assetValidator.validCreatedBy(target, user)
        return assetRemover.remove(target, user)
    }
}
