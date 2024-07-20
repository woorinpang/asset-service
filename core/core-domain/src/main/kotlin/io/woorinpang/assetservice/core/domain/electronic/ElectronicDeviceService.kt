package io.woorinpang.assetservice.core.domain.electronic

import org.springframework.stereotype.Component

@Component
class ElectronicDeviceService(
    val electronicDeviceAppender: ElectronicDeviceAppender,
) {
    fun appendElectronicDevice(
        target: ElectronicDeviceTarget,
        personalComputer: ElectronicDevice,
    ): Long {
        return electronicDeviceAppender.append(target, personalComputer)
    }
}