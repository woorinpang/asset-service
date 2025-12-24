package io.woorinpang.assetservice.core.domain.asset

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
        userId: Long,
        type: AssetType,
    ): Long {
        assetValidator.existsUserIdAndType(userId, type)
        return assetAppender.append(userId, type)
    }

    fun findAsset(target: AssetTarget): Asset = assetFinder.find(target)

    fun deleteAsset(
        target: AssetTarget,
        userId: Long,
    ): Any {
        assetValidator.validCreatedBy(target)
        return assetRemover.remove(target, userId)
    }
}
