package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.enums.AssetType
import org.springframework.stereotype.Component

@Component
class AssetAppender(
    val assetRepository: AssetRepository,
) {
    fun append(userId: Long, type: AssetType): Long = assetRepository.append(userId, type, userId)
}
