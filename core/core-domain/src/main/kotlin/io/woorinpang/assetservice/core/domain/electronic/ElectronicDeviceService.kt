package io.woorinpang.assetservice.core.domain.electronic

import org.springframework.stereotype.Component

@Component
class ElectronicDeviceService(
    val electronicDeviceAppender: ElectronicDeviceAppender,
    val electronicDeviceRemover: ElectronicDeviceRemover
) {
    fun appendElectronicDevice(
        assetId: Long,
        personalComputer: ElectronicDevice,
    ): Long {
        return electronicDeviceAppender.append(assetId, personalComputer)
    }

    fun removeElectronicDevice(
        target: ElectronicDeviceTarget
    ) {
        electronicDeviceRemover.remove(target)
    }
}