package io.woorinpang.assetservice.storage.db.core.asset

import io.woorinpang.assetservice.core.enums.AssetType
import org.springframework.data.jpa.repository.JpaRepository

interface AssetEntityJpaRepository : JpaRepository<AssetEntity, Long> {
    fun existsByUserIdAndType(userId: Long, type: AssetType): Boolean
}
