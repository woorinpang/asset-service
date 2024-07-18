package io.woorinpang.assetservice.storage.db.core.electronic

import org.springframework.data.jpa.repository.JpaRepository

interface ElectronicDeviceEntityJpaRepository : JpaRepository<ElectronicDeviceEntity, Long> {
    fun findByAssetIdAndType(assetId: Long, name: String): ElectronicDeviceEntity?
}