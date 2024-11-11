package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Component

@Component
class ElectronicDeviceAppender(
    val electronicDeviceRepository: ElectronicDeviceRepository,
) {
    fun append(
        assetId: Long,
        type: ElectronicDeviceType,
        electronicDevice: ElectronicDevice,
        user: User,
    ): Long = electronicDeviceRepository.append(assetId, type, electronicDevice, user)
}
