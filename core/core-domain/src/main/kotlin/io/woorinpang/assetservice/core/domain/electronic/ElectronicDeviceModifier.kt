package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.storage.db.core.electronic.ElectronicDeviceEntityJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ElectronicDeviceModifier(
    val electronicDeviceEntityJpaRepository: ElectronicDeviceEntityJpaRepository,
) {
    @Transactional
    fun modify(
        target: ElectronicDeviceTarget,
        user: User,
        electronicDevice: ElectronicDevice,
    ) {
        ElectronicDeviceHelper
            .findElectronicDeviceById(electronicDeviceEntityJpaRepository, target.id)
            .modify(
                electronicDevice.manufacturer,
                electronicDevice.model,
                electronicDevice.serialNumber,
                electronicDevice.price.value,
                user.email,
            )
    }
}
