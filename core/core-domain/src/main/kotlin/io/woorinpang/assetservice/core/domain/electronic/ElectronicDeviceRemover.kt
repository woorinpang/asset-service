package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Component

@Component
class ElectronicDeviceRemover(
    val electronicDeviceRepository: ElectronicDeviceRepository,
) {
    fun remove(
        target: ElectronicDeviceTarget,
        user: User,
    ) {
        electronicDeviceRepository.removeElectronicDevice(target.id, user)
    }
}
