package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ElectronicDeviceAppender(
    val electronicDeviceEntityJpaRepository: ElectronicDeviceEntityJpaRepository,
) {
    @Transactional
    fun append(
        target: ElectronicDeviceTarget,
        electronicDevice: ElectronicDevice
    ): Long {
        return electronicDeviceEntityJpaRepository.save(electronicDevice.toEntity(target)).id!!
    }
}