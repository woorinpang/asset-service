package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Component

@Component
class ElectronicDeviceModifier(
    val electronicDeviceRepository: ElectronicDeviceRepository,
) {
    fun modify(
        target: ElectronicDeviceTarget,
        user: User,
        electronicDevice: ElectronicDevice,
    ) {
        electronicDeviceRepository.modifyElectronicDevice(target.id, user, electronicDevice)
    }
}
