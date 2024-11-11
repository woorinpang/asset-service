package io.woorinpang.assetservice.core.domain.electronic

import io.woorinpang.assetservice.core.domain.user.User
import org.springframework.stereotype.Component

@Component
class ElectronicDeviceValidator(
    val electronicDeviceRepository: ElectronicDeviceRepository,
) {
    fun validCreatedBy(
        target: ElectronicDeviceTarget,
        user: User,
    ) {
        val findElectronicDevice =
            ElectronicDeviceHelper.findElectronicDeviceById(electronicDeviceRepository, target.id)

    }
}
