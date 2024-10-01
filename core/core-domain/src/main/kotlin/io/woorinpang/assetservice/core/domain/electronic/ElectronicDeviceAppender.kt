package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ElectronicDeviceAppender(
    val electronicDeviceEntityJpaRepository: ElectronicDeviceEntityJpaRepository,
) {
    @Transactional
    fun append(
        assetId: Long,
        type: ElectronicDeviceType,
        electronicDevice: ElectronicDevice,
        user: User,
    ): Long {
        return electronicDeviceEntityJpaRepository.save(electronicDevice.toEntity(assetId, type, user.email)).id!!
    }
}
