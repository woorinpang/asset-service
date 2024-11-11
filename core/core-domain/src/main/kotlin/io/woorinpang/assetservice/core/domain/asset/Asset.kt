package io.woorinpang.assetservice.core.domain.asset

import io.woorinpang.assetservice.core.enums.AssetType
import java.time.LocalDateTime

data class Asset private constructor(
    val id: Long?,
    val userId: Long,
    val type: AssetType,
    val createdBy: String,
    val createdAt: LocalDateTime,
    val deleted: Boolean,
) {
    companion object {
        fun of(assetId: Long, userId: Long, assetType: AssetType, createdBy: String, createdAt: LocalDateTime, deleted: Boolean): Asset =
            Asset(
                id = assetId,
                userId = userId,
                type = assetType,
                createdBy = createdBy,
                createdAt = createdAt,
                deleted = deleted,
            )
    }
}
